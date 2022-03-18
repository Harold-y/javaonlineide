package org.chengbing.service;

import org.chengbing.dao.HistoryDao;
import org.chengbing.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    HistoryDao mapper;

    public List<History> getRecentHistory()
    {
        return mapper.getRecentHistory();
    }

    public int updateProject(String path, String type)
    {
        History history = mapper.getRecord(path);
        if(history!= null && history.getHistoryId() != null)
        {
            mapper.updateProjectLastUsedTime(path);
            return mapper.updateProject(path);
        }else{
            String name = path.substring(path.lastIndexOf(System.getProperty("file.separator")) + 1);
            mapper.insertRecord(path, name, type);
            return mapper.updateProject(path);
        }
    }

    public int insertProject(String path, String name, String type)
    {
        mapper.insertRecord(path, name, type);
        return mapper.updateProject(path);
    }
}
