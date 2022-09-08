package com.example.hsm_demo.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("alien_banner")
public class BannerPo {

    private Long id;

    private String image;

    private String link;

    private Integer sortValue;

    private Date createTime;

    private Date updateTime;
}
