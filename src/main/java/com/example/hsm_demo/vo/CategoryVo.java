package com.example.hsm_demo.vo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CategoryVo {
    private Long id;
    private String name;
    private Integer type;
    private Integer level;
    private List<CategoryVo> subList;
}
