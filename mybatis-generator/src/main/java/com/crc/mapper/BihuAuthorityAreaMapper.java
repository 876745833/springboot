package com.crc.mapper;

import com.crc.pojo.BihuAuthorityArea;
import com.crc.pojo.BihuAuthorityAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BihuAuthorityAreaMapper {
    long countByExample(BihuAuthorityAreaExample example);

    int deleteByExample(BihuAuthorityAreaExample example);

    int insert(BihuAuthorityArea record);

    int insertSelective(BihuAuthorityArea record);

    List<BihuAuthorityArea> selectByExample(BihuAuthorityAreaExample example);

    int updateByExampleSelective(@Param("record") BihuAuthorityArea record, @Param("example") BihuAuthorityAreaExample example);

    int updateByExample(@Param("record") BihuAuthorityArea record, @Param("example") BihuAuthorityAreaExample example);
}