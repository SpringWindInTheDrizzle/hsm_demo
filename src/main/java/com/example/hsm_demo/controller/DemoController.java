package com.example.hsm_demo.controller;

import com.example.hsm_demo.repository.po.DemoPo;
import com.example.hsm_demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pianist
 */

/**
 * RestController是@Controller和@ResponseBody的融合，
 * ResponseBody将数据库的返回的数据，自己变成json格式
 * Controller控制类，@bean被Spring管理，与Mapping中的路径合并
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @GetMapping("/test")
    public DemoPo test(Long id){
        return demoService.getById(id);
    }
}
