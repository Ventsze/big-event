package com.ventsze.controller;

import com.ventsze.pojo.Result;
import com.ventsze.pojo.User;
import com.ventsze.service.UserService;
import com.ventsze.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$")String username,@Pattern(regexp = "^\\S{5,16}$")String password){
        //查询用户
        User u = userService.findByUserName(username);
        if( u == null ){
            //用户名没有占用
            //注册
            userService.register(username,password);
            return Result.success();
        }else {
            //用户名被占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$")String username,@Pattern(regexp = "^\\S{5,16}$")String password){

        //根据用户名查询用户
        User loginUser = userService.findByUserName(username);

        //判断用户是否存在
        if ( loginUser == null ){
            return Result.error("用户名错误");
        }

        //判断密码是否正确 loginUser对象中的password是密文
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            //登录成功
            return Result.success("jwt token");
        }

        return Result.error("密码错误");

    }

}

