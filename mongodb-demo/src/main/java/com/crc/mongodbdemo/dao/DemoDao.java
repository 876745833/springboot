package com.crc.mongodbdemo.dao;

import com.crc.mongodbdemo.entity.DemoEntity;

/**
 * @Author CRC
 * @Date 2020/6/4
 * @Describe
 */

public interface DemoDao {

    void saveDemo(DemoEntity demoEntity);

    void removeDemo(Long id);

    void updateDemo(DemoEntity demoEntity);

    DemoEntity findDemoById(Long id);
}

