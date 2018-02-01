package com.dawn.service.impl;

import com.dawn.jedis.dao.JedisClient;
import com.dawn.mapper.MobileUserMapper;
import com.dawn.pojo.MobileUser;
import com.dawn.pojo.MobileUserExample;
import com.dawn.service.MobileUserService;
import com.dawn.util.DawnResult;
import com.dawn.util.JsonUtils;
import com.dawn.util.JwtHelper;
import com.dawn.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 2018/1/26.
 */
@Service
public class MobileUserServiceimpl implements MobileUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileUserServiceimpl.class);
    @Resource
    private MobileUserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;
    public DawnResult loginUser(String phone, String password) {
      try {
          MobileUserExample example = new MobileUserExample();

        MobileUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<MobileUser> list = userMapper.selectByExample(example);

        // 判断该用户是否存在
        if (list.size() <= 0) {
            return DawnResult.build(400, "该用户不存在！");
        } else {
            // 获取用户对象
            MobileUser mobileUser = list.get(0);
            // 判断用户的密码
            // 密码是经过MD5加密
            // 获取到用户的密码
            String pwd_db = mobileUser.getPassword(); // 获取到数据库密码

            // 1获得颜值
            String salt = mobileUser.getSalt();
            // 2加密
            String salt_pwd = password + salt;
            // 拿数据库密码和页面输入的密码进行比对
            // 页面 密码 111111 使用md5加密进行对比
            String pwd_input = DigestUtils.md5DigestAsHex(salt_pwd.getBytes());

            if (!pwd_db.equalsIgnoreCase(pwd_input)) {
                return DawnResult.build(400, "用户名或密码不正确！");
            }
            //密码置空
            mobileUser.setPassword(null);
            //盐值置空
            mobileUser.setSalt(null);

            //jwt的负载
            Map<String, String> clamis = new HashMap<String, String>();

            clamis.put("user", JsonUtils.objectToJson(mobileUser));
            String jwtStr = JwtHelper.createJWT(clamis, 86400);
            jwtStr = "bearer" + jwtStr;

            //将jwt token存入redis中
            jedisClient.set("USER_REDIS_JWT_TOKEN:" + mobileUser.getPid() + ":base", jwtStr);
            //设置生命周期
            jedisClient.expire("USER_REDIS_JWT_TOKEN:" + mobileUser.getPid() + ":base", 86400);//24小时生命周期

            //数据存入到redis中
            jedisClient.set("USER_REDIS_KEY:" + mobileUser.getPid() + ":base", JsonUtils.objectToJson(mobileUser));
            //设置生命周期
            jedisClient.expire("USER_REDIS_KEY:" + mobileUser.getPid() + ":base", 86400);//24小时生命周期

            //登陆成功获取用户个人信息
            String userRedis = jedisClient.get("USER_REDIS_KEY:" + mobileUser.getPid() + ":base");
            if (userRedis == null) {
                return DawnResult.build(400, "需要重新登录");
            }
            String jwtToken = jedisClient.get("USER_REDIS_JWT_TOKEN:" + mobileUser.getPid() + ":base");
            if (jwtToken == null) {
                return DawnResult.build(400, "jwt token过期请重新登录");
            }
            return DawnResult.ok(jwtStr);
        }

        }catch(Exception e){
          LOGGER.error("用户登录异常", e);
          return  null;
      }
    }

    /**
     * 注册
     * @param phone
     * @param password
     * @return
     */
    public DawnResult addRegister(String phone, String password) {
        //SnowflakeIdWorker：工具类（ID生成器）
        //getInstance（）：获取类的实例
        //nextId()：获得下一个ID
     try {
         long worker = SnowflakeIdWorker.getInstance().nextId();

        String salt_pwd = password + worker;
        //新建一个对象，设置属性
        MobileUser user = new MobileUser();
        user.setSalt(String.valueOf(worker));
        user.setPassword(DigestUtils.md5DigestAsHex(salt_pwd.getBytes()));
        user.setPhone(phone);
        user.setPname(UUID.randomUUID().toString());
        //调用添加方法
        int userid = userMapper.insert(user);
        System.out.println(userid);
        if (userid > 0) {
            return DawnResult.ok(user);

        }
        return DawnResult.build(400, "注册失败");
    }catch(Exception e){
         LOGGER.error("注册用户异常", e);
         return  null;
     }
    }


    public DawnResult updateUser(String username, String pname, String img, Integer age, String sex, String exp, String job, String email, String address, String hobby) {

     try {
         MobileUserExample example = new MobileUserExample();

         MobileUserExample.Criteria criteria = example.createCriteria();
         criteria.andPidEqualTo(1);

         MobileUser user = new MobileUser();
         user.setUsername(username);
         user.setPname(pname);
         user.setImg(img);
         user.setAge(age);
         user.setSex(sex);
         user.setExp(exp);
         user.setJob(job);
         user.setEmail(email);
         user.setAddress(address);
         user.setHobby(hobby);
         int i = userMapper.updateByExampleSelective(user, example);
         if (i > 0) {
             return DawnResult.ok("修改成功");
         }
         return DawnResult.build(400, "修改失败");
     }catch (Exception e){
         LOGGER.error("修改个人信息异常", e);
         return  null;
     }

    }

    /**
     * 修改密码
     * @param pid
     * @param password
     * @param pwd
     * @return
     */
    public DawnResult updatePwd(Integer pid,String password,String pwd) {
        try {
            MobileUser mobileUser = userMapper.selectByPrimaryKey(pid);

            String salt = mobileUser.getSalt();
            String salt_pwd = password + salt;
            // 拿数据库密码和页面输入的密码进行比对
            // 页面 密码 111111 使用md5加密进行对比
            String pwd_input = DigestUtils.md5DigestAsHex(salt_pwd.getBytes());
            if (pwd_input.equals(mobileUser.getPassword())) {
                String salt_pwd1 = password + salt;
                // 拿数据库密码和页面输入的密码进行比对
                // 页面 密码 111111 使用md5加密进行对比
                String pwd_input1 = DigestUtils.md5DigestAsHex(salt_pwd.getBytes());
                mobileUser.setPassword(pwd_input1);
                userMapper.updateByPrimaryKey(mobileUser);
                return DawnResult.ok("修改密码成功");
            }
            return DawnResult.build(400, "修改失败");
        } catch (Exception e) {
            LOGGER.error("修改个人信息异常", e);
            return null;
        }

    }
}
