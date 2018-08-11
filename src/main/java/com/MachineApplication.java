package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Configuration,@EnableAutoConfiguration,@ComponentScan
 * 如果你的main application class的位置确实在包的根路径上，上面的三个注解，可以用@SpringBootApplication这一个注解代替。
 */

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableCaching
@MapperScan(value = "com.huangpeng.cloud.mybatisExample.mapper")
public class MachineApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MachineApplication.class, args);
	}
}
