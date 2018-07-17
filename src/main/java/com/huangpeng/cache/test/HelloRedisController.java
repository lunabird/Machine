package com.huangpeng.cache.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-06-23 下午2:43
 * 类名: HelloController
 * </pre>
 **/
@RestController
public class HelloRedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/helloRedis")
    public String index() {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String string = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println(string);

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("batman", 30);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("spiderman", 40);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        User u1 = (User)redisTemplate.opsForValue().get("超人");
        User u2 = (User)redisTemplate.opsForValue().get("batman");
        User u3 = (User)redisTemplate.opsForValue().get("spiderman");

        System.out.println(u1.getUserName()+"\t"+u1.getAge());
        System.out.println(u2.getUserName()+"\t"+u2.getAge());
        System.out.println(u3.getUserName()+"\t"+u3.getAge());

        return "Hello redis";
    }
}
