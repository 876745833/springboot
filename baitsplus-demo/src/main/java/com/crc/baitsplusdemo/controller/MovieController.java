package com.crc.baitsplusdemo.controller;


import com.crc.baitsplusdemo.entity.Movie;
import com.crc.baitsplusdemo.http.Main;
import com.crc.baitsplusdemo.mapper.MovieMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;

/**
 * @author crc
 * @since 2020-06-03
 * 爬虫：豆瓣的电影首页
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @Resource
    private MovieMapper movieMapper;

    @RequestMapping("insert")
    @ResponseBody
    public String insert(){
        Main main = new Main();
        List<Movie> list = main.getList();
        for (Movie movie : list) {
            movieMapper.insert(movie);
        }
        return "sucess";
    }




}

