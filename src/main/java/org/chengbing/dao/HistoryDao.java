package org.chengbing.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.chengbing.entity.History;

import java.util.List;

@Mapper
public interface HistoryDao {

    @Select("select historyId, historyPath, historyName, historyType, historyLastTime from history order by historyLastTime DESC limit 0, 6")
    List<History> getRecentHistory();

    @Update("update projectpath set projectpath = #{path}")
    int updateProject(String path);

    @Update("update history set historyLastTime = NOW() where historyPath = #{path}")
    int updateProjectLastUsedTime(String path);

    @Select("select historyId, historyPath, historyName, historyType, historyLastTime from history where historyPath = #{path}")
    History getRecord(String path);

    @Insert("insert into history (historyPath, historyName, historyType, historyLastTime) values (#{path}, #{name}, #{type}, NOW())")
    int insertRecord(String path, String name, String type);
}
