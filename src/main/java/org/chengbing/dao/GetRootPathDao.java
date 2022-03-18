package org.chengbing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GetRootPathDao {
    @Select("select projectPath from projectPath")
    String getProjectRootPath();
    @Select("select projectType from projecttype")
    String getProjectType();
}
