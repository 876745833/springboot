package com.crc.redisdemo;

import com.crc.redisdemo.redis.RedisService;
import com.crc.redisdemo.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author CRC
 * @Date 2020/5/7
 * @Describe redisService工具包测试
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisService redisService;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void setRedis() {
        redisService.setKey("redis", "一会就到期",10l, TimeUnit.SECONDS);
        System.out.println(redisService.existsKey("redis"));
    }

    @Test
    public void lock(){
        redisUtil.lock("name");
    }


}
