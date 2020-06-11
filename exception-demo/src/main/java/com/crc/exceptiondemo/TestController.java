package com.crc.exceptiondemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author CRC
 * @Date 2020/5/25
 * @Describe
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public void test(){
        throw new NullPointerException("空指针异常");
    }
}
