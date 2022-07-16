package com.example.hsm_demo.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("alien_cat_category")

public class CategoryPo {
    private Long id;
    private Integer level;
    private String name;
    private Long parentId;
    private Integer type;
    private Date createTime;
    private Date updateTime;
}
