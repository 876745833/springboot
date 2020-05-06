package com.crc.baitsplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crc.baitsplusdemo.entity.BihuAuthorityArea;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crc
 * @since 2020-04-24
 */
public interface BihuAuthorityAreaMapper extends BaseMapper<BihuAuthorityArea> {

    List<BihuAuthorityArea> findByCity(String parentId);
}
