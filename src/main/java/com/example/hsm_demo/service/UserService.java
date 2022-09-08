package com.example.hsm_demo.service;

import com.example.hsm_demo.auth.UserDetail;

public interface UserService {


    UserDetail checkPassword(String userName, String phoneNum, String password);

    Boolean register(String userName, String password, String phoneNum);
}
