package com.dawn.controller;

import com.dawn.pojo.SysUser;
import com.dawn.service.SysUserService;
import com.dawn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/28.
 */
@RestController
@RequestMapping("/background/sysuser/*")
public class SysUsersController {

    @Autowired
    private SysUserService userService;
    //全查
    @RequestMapping("/findUserAll")
    @ResponseBody
    public Result findSysUserAll(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "rows",defaultValue = "10")int rows) {
        return userService.findSysUsersfindAll(page, rows);
    }

    //添加
    @RequestMapping("/addUser")
    @ResponseBody
    public Map addSysUser(Integer roleId,@RequestBody SysUser user) {
        Map map = new HashMap();
        try {
            user.setParentId(1);// 都归超级用户管理
            userService.addSysUser(user, roleId);
            map.put("success", "保存成功!!!");
            return map;
        } catch (Exception e) {
            map.put("errorMsg", "保存失败");
            e.printStackTrace();
            return map;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map deleteSysUser(String ids) {
        String[] strid = ids.split(",");
        Map map = new HashMap ();
        try {
            for (int i = 0; i < strid.length; i++) {
                userService.deleteSysUser(Integer.valueOf(strid[i]));
            }
            map.put("delNums", strid.length);// 删除条数
            map.put("success", "删除成功");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("errorMsg", "删除失败!!");
            return map;
        }
    }

    @RequestMapping("update")
    @ResponseBody
    public Map updateSysUser(@RequestBody SysUser user,int roleId) {

        Map map = new HashMap();
        try {
            userService.updateSysUser(user, roleId);
            map.put("success", "保存成功!!!");
            return map;
        } catch (Exception e) {
            map.put("errorMsg", "保存失败");
            e.printStackTrace();
            return map;
        }
       /* int i = userService.updateSysUser(user,roleId);
        String msg = "";
        if (i > 0) {
            msg = "{\"msg\":\"修改成功\"}";
        } else {
            msg = "{\"errorMsg\":\"修改失败\"}";
        }
        return msg;*/
    }

    @RequestMapping("findOne")
    @ResponseBody
    public SysUser findOne(Integer id){
        return  userService.findByIdSysUser(id);
    }
}
