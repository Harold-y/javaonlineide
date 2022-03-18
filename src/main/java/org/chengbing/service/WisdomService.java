package org.chengbing.service;

import org.chengbing.dao.WisdomDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class WisdomService implements WisdomDao{
    @Resource
    WisdomDao mapper;

    @Override
    public Map<String, String> randomWisdom()
    {
        return mapper.randomWisdom();
    }
}
