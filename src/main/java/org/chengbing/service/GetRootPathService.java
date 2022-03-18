package org.chengbing.service;

import org.chengbing.dao.GetRootPathDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GetRootPathService implements GetRootPathDao {

    @Resource
    GetRootPathDao dao;

    @Override
    public String getProjectRootPath() {
        return dao.getProjectRootPath();
    }

    @Override
    public String getProjectType() {
        return dao.getProjectType();
    }
}
