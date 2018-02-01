package com.dawn.controller;

import com.dawn.service.MobileUserService;
import com.dawn.util.DawnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/1/26.
 */

@RestController
@RequestMapping("/dawnapp/mobile")
public class MobileUserController {
    @Autowired
    private MobileUserService userService;

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/user/login")
    public DawnResult login(String phone, String password) {

        DawnResult dawnResult = userService.loginUser(phone, password);
        return dawnResult;
    }
    /*
    查询个人信息
     *//*
    @RequestMapping("/user/info")

    public String getUserInfo(HttpServletRequest request){
        String auth = request.getHeader("Authorization");
        String user = "";
        if(auth!=null &&( auth.length()>6)){
            String headStr = auth.substring(0,6).toLowerCase();
            if(headStr.compareTo("bearer")==0){
                auth = auth.substring(6,auth.length());
                Claims claims = JwtHelper.parseJWT(auth);
                if(claims!=null){
                    user = (String)claims.get("user");
                }
            }
        }
        return user;
    }*/

    /**
     * 手机注册账号
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/user/regist")
    public DawnResult getRegister(String phone,String password){
        return userService.addRegister(phone,password);
    }

    /**
     * 修改信息
     * @param username
     * @param pname
     * @param img
     * @param age
     * @param sex
     * @param exp
     * @param job
     * @param email
     * @param address
     * @param hobby
     * @return
     */
    @RequestMapping("/user/perfect")
    public DawnResult updateUser(String username,String pname,String img,Integer age,String sex,String exp,String job,String email,String address,String hobby){
        return userService.updateUser(username,pname,img,age,sex,exp,job,email,address,hobby);
    }
    //修改密码
    @RequestMapping("/user/pwd")
    public DawnResult updatPaw(Integer pid,String password,String pwd){
        return userService.updatePwd(pid,password,pwd);
    }


}
