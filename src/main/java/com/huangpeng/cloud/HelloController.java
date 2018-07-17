package com.huangpeng.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2017-11-18 下午3:29
 * 类名: HelloController
 * </pre>
 **/
@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="/hello",produces="text/plain;charset=UTF-8")
    public String index() {
        logger.info("Hello world Method has been called.");
        return "Hello World";
    }

    @RequestMapping("/hi")
    public String index(ModelMap map){
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host","http://www.baidu.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
