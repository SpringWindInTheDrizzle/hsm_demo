package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.auth.UserDetail;
import com.example.hsm_demo.repository.mapper.impl.UserMapperServiceImpl;
import com.example.hsm_demo.repository.po.UserPo;
import com.example.hsm_demo.service.UserService;
import com.example.hsm_demo.util.MD5Util;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperServiceImpl userMapperService;
    @Override
    public UserDetail checkPassword(String userName, String phoneNum, String password) {
        password = MD5Util.digest(password);
        UserPo user;
        if (userName != null) {
            // sql: select * from alien_user where user_name=$userName)
            user = userMapperService.getOne(new QueryWrapper<UserPo>().lambda().eq(UserPo::getUserName, userName));
        } else {
            // sql: select * from alien_user where phone_num=phoneNum)
            user = userMapperService.getOne(new QueryWrapper<UserPo>().lambda().eq(UserPo::getPhoneNum, phoneNum));
        }
        if (user == null) {
            return null;
        }
        return password.equals(user.getPassword()) ? buildUserDetail(user) : null;
    }

    @Override
    public Boolean register(String userName, String password, String phoneNum) {
        password = MD5Util.digest(password);
        UserPo insertPo = new UserPo().setUserName(userName).setPassword(password).setPhoneNum(phoneNum);
        return userMapperService.save(insertPo);
    }

    private UserDetail buildUserDetail(UserPo user) {
        return new UserDetail().setUserId(user.getId()).setUserName(user.getUserName()).setPhoneNum(user.getPhoneNum());
    }
}
