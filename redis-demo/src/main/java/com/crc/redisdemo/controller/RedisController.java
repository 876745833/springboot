package com.crc.redisdemo.controller;

import com.crc.redisdemo.redis.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author CRC
 * @Date 2020/5/6
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(String name){
        return "hello redis " + name;
    }

    @GetMapping("/get")
    public void getRedis(String key){
        RedisUtil util = new RedisUtil();
        util.get(key);
    }

    @GetMapping("/set")
    public void setRedis(String key, String value){
        RedisUtil util = new RedisUtil();
        util.set(key, value);
    }

    @GetMapping("/lock")
    public void lock(String key){
        RedisUtil util = new RedisUtil();
        util.lock(key);
    }

    @GetMapping("/unlock")
    public void unlock(String key){
        RedisUtil util = new RedisUtil();
        util.delete(key);
    }
}
