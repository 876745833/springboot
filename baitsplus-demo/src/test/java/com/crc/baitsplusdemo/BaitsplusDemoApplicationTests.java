package com.crc.baitsplusdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crc.baitsplusdemo.entity.BihuAuthorityArea;
import com.crc.baitsplusdemo.mapper.BihuAuthorityAreaMapper;
import com.crc.baitsplusdemo.service.BihuAuthorityAreaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BaitsplusDemoApplicationTests {

    @Resource
    private BihuAuthorityAreaMapper mapper;

    @Test
    void contextLoads() {
        List<BihuAuthorityArea> byCity = mapper.findByCity("110100");
        for (BihuAuthorityArea bihuAuthorityArea : byCity) {
            System.out.println(bihuAuthorityArea.toString());
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void selectPageLoads() {
        Page<BihuAuthorityArea> page = new Page<>(1,5);
        IPage<BihuAuthorityArea> lstUser = mapper.selectPage(page, null);
        List<BihuAuthorityArea> records = lstUser.getRecords();
        for (BihuAuthorityArea record : records) {
            System.out.println(record);
        }
    }

}
