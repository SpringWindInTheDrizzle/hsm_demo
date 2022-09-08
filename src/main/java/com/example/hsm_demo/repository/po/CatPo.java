package com.example.hsm_demo.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("alien_cat")
public class CatPo {

    private Long id;

    private String name;

    private Long merchantId;

    private String planetId;

    private Byte sex;

    private Integer age;

    private Integer nucleicStatus;

    private String price;

    private String introduction;

//    private Date createTime;
//
//    private Date updateTime;
}
