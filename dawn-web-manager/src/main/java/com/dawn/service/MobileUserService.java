package com.dawn.service;

import com.dawn.util.DawnResult;

/**
 * Created by admin on 2018/1/26.
 */
public interface MobileUserService {

    DawnResult loginUser(String userPhone, String password);

    DawnResult addRegister(String phone,String password);

  DawnResult updatePwd(Integer pid,String password,String pwd);

    DawnResult updateUser(String username,String pname,String img,Integer age,String sex,String exp,String job,String email,String address,String hobby);

}
