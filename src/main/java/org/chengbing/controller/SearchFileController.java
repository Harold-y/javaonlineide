package org.chengbing.controller;

import org.chengbing.entity.Folder;
import org.chengbing.service.GetRootPathService;
import org.chengbing.util.Result;
import org.chengbing.util.SearchFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/sf")
public class SearchFileController {

    @Resource
    GetRootPathService service;

    @GetMapping("/searchFile")
    @ResponseBody
    public Result<Folder> searchFile()
    {
        Result<Folder> r = new Result<>();
        SearchFileUtil util = new SearchFileUtil();
        r.setT(util.search(service.getProjectRootPath()));
        return r;
    }

    @GetMapping("/searchFilePath")
    @ResponseBody
    public Result<Folder> searchFilePath(String path)
    {
        Result<Folder> r = new Result<>();
        SearchFileUtil util = new SearchFileUtil();
        r.setT(util.search(path));
        return r;
    }
}
