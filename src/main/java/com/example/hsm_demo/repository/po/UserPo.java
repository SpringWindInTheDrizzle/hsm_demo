package com.example.hsm_demo.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("alien_user")
public class UserPo {

    private Long id;

    private String phoneNum;

    private String password;

    private String userName;

    private Date createTime;

    private Date updateTime;
}
