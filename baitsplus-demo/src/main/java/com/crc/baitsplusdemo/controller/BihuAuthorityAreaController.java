package com.crc.baitsplusdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crc.baitsplusdemo.entity.BihuAuthorityArea;
import com.crc.baitsplusdemo.mapper.BihuAuthorityAreaMapper;
import com.crc.baitsplusdemo.service.BihuAuthorityAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author crc
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/bihuAuthorityArea")
public class BihuAuthorityAreaController {
    @Resource
    private BihuAuthorityAreaService service;
    @Resource
    private BihuAuthorityAreaMapper mapper;

    /**
     * 通过Id查询
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public BihuAuthorityArea getMes(@PathVariable Long id){
        BihuAuthorityArea bihuAuthorityArea = this.service.getById(id);
        return bihuAuthorityArea;
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/area")
    public List<BihuAuthorityArea> getAll2(){
        List<BihuAuthorityArea> list = service.list();
        return list;
    }

    /**
     * 通过名字查询
     * @param name
     * @return
     */
    @GetMapping("/name")
    public BihuAuthorityArea getByName(@RequestParam(name = "name")String name){
        QueryWrapper<BihuAuthorityArea> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return  this.service.getOne(wrapper);
    }

    /**
     * 分页查询
     */
    @GetMapping("/areaPage")
    public List<BihuAuthorityArea> selectPageLoads(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "15") int pageSize,
                                @RequestParam(name = "data",required = false) BihuAuthorityArea  data){
        Page<BihuAuthorityArea> page = new Page<>(pageNum,pageSize);
        QueryWrapper<BihuAuthorityArea> wrapper = new QueryWrapper<>();
//        wrapper.lambda().eq(BihuAuthorityArea::getParentId,data.getParentId());
        IPage<BihuAuthorityArea> lstUser = mapper.selectPage(page, wrapper);
        List<BihuAuthorityArea> records = lstUser.getRecords();
        return records;
    }

}

