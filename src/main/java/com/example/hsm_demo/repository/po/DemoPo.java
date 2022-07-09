package com.example.hsm_demo.repository.po;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *Data调用Lombok,编译期自动补全set get（也可以用反射实现，但是反射性能不好）
 * Data return this
 *
 */
@Data
@Accessors(chain = true)
@TableName("demo")
public class DemoPo {
    private Long id;
    private Integer sex;
    private String name;
    private Integer age;
}
