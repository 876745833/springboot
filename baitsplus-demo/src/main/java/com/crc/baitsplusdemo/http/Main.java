package com.crc.baitsplusdemo.http;

import com.alibaba.fastjson.JSON;
import com.crc.baitsplusdemo.entity.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CRC
 * @Date 2020/6/3
 * @Describe
 */
public class Main {

    public List<Movie> getList() {
        int start;//每页多少条
        int total = 0;//记录数
        int end = 9979;//总共9979条数据
        List<Movie> list = new ArrayList<>();
        for (start = 0; start <= end; start += 20) {
            try {
                String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;
                JSONObject dayLine = new GetJson().getHttpJson(address, 1);

                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("data");
                list = JSON.parseArray(json.toString(), Movie.class);
                if (start <= end) {
                    System.out.println("已经爬取到底了");
                }
//                for (Movie movie : list) {
//                    movieMapper.insert(movie);
//                }
                total += list.size();
                System.out.println("正在爬取中---共抓取:" + total + "条数据");

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return list;

    }
}

