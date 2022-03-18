package org.chengbing.controller;

import org.chengbing.entity.History;
import org.chengbing.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService service;

    @GetMapping("/getRecentHistory")
    public List<History> getRecentHistory()
    {
        return service.getRecentHistory();
    }
    @PostMapping("/updatePath")
    public int updateProject(String path, String type)
    {
        return service.updateProject(path, type);
    }

}
