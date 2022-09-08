package com.example.hsm_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hsm_demo.auth.UserDetail;
import com.example.hsm_demo.repository.mapper.UserMapper;
import com.example.hsm_demo.repository.po.UserPo;
import com.example.hsm_demo.service.UserService;
import com.example.hsm_demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetail checkPassword(String userName, String phoneNum, String password) {
        password = MD5Util.digest(password);
        UserPo user;
        if (userName != null) {
            // sql: select * from alien_user where user_name=$userName)
            user = userMapper.selectOne(new QueryWrapper<UserPo>().lambda().eq(UserPo::getUserName, userName));
        } else {
            // sql: select * from alien_user where phone_num=phoneNum)
            user = userMapper.selectOne(new QueryWrapper<UserPo>().lambda().eq(UserPo::getPhoneNum, phoneNum));
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
        return userMapper.insert(insertPo) > 0;
    }

    private UserDetail buildUserDetail(UserPo user) {
        return new UserDetail().setUserId(user.getId()).setUserName(user.getUserName()).setPhoneNum(user.getPhoneNum());
    }
}
