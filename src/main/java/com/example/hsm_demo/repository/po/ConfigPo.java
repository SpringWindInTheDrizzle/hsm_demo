package com.example.hsm_demo.repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("alien_config")
public class ConfigPo {

    private Long id;

    private Integer type;

    private Long relateId;

    private Integer sortValue;

    private Date createTime;

    private Date updateTime;
}
