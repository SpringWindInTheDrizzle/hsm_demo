package com.example.hsm_demo.controller;

import com.example.hsm_demo.auth.UserDetail;
import com.example.hsm_demo.service.UserService;
import com.example.hsm_demo.vo.Response;
import com.example.hsm_demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login/password")
    @ResponseBody
    public Response login(@RequestBody UserVo user,
                        HttpServletRequest request) {
       UserDetail userDetail = userService.checkPassword(user.getUserName(), user.getPhoneNum(), user.getPassword());
       if (userDetail == null) {
           return Response.failResponse("用户不存在或密码错误");
       }
       request.getSession().setAttribute("USER_SESSION_KEY", userDetail);
       return Response.success();
    }

    @GetMapping("/logout")
    public Response logout(HttpServletRequest request) {
        request.getSession().setAttribute("USER_SESSION_KEY", null);
        return Response.success();
    }

    @PostMapping("/register")
    public Response register(@RequestBody UserVo user) {
        boolean check = userService.register(user.getUserName(), user.getPassword(), user.getPhoneNum());
        if (!check) {
            return Response.failResponse("注册失败");
        }
        return Response.success();
    }
}
