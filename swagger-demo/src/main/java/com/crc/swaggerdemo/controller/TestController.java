package com.crc.swaggerdemo.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Author CRC
 * @Date 2020/5/7
 * @Describe
 */
@Api(tags = "swagger-api测试")
@RestController
public class TestController {

    @GetMapping("swagger")
    @ApiOperation(value = "测试get", notes = "测试get")
    public String swgetTest(){
        return "get success";
    }

    @PostMapping("swagger")
    @ApiOperation(value = "测试post", notes = "测试post")
    public String swpostTest(){
        return "post success";
    }

    @DeleteMapping("swagger")
    @ApiOperation(value = "测试delete", notes = "测试delete")
    public String swdeleteTest(){
        return "delete success";
    }

    @PutMapping("swagger")
    @ApiOperation(value = "测试put", notes = "测试put")
    public String swputTest(){
        return "put success";
    }

    @ApiOperation(value = "登录" ,  notes="登录 接口")
    @RequestMapping(path = "/login" , method = {RequestMethod.POST})
    public String login2(@RequestParam(value = "name" ) @ApiParam(value = "账号",required = true) String name,
                         @RequestParam(value = "pwd" ) @ApiParam(value = "密码",required = true) String pwd) throws Exception {
        return "登录账号为 "+name +"<-->"+ pwd;
    }


}
