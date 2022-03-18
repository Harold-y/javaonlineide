package org.chengbing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface WisdomDao {
    @Select("select wisdomDescription, wisdomOrigin from wisdom ORDER BY RAND() limit 1")
    public Map<String, String> randomWisdom();

}
