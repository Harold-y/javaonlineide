package org.chengbing.controller;

import org.chengbing.service.FileOperationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/fileOp")
public class FileOperationController {
    @Resource
    FileOperationService service;

    @GetMapping("/getImageBase64")
    @ResponseBody
    public String getBase64Image(String path)
    {
        return service.getBase64Image(path);
    }

    @GetMapping("/getContent")
    @ResponseBody
    public String getContent(String path)
    {
        return service.getFileContent(path);
    }

    @PostMapping("/updateFile")
    @ResponseBody
    public int updateFile(String path, String content)
    {
        return service.updateFileContent(path, content);
    }

    @DeleteMapping("/deleteFile")
    @ResponseBody
    public boolean deleteFile(@RequestParam String path)
    {
        return service.deleteFile(path);
    }

    @PostMapping("/createFile")
    @ResponseBody
    public boolean createFile(String path, String name)
    {
        return service.createFile(path, name);
    }

    @PostMapping("/createDir")
    @ResponseBody
    public boolean createDir(String path, String name)
    {
        return service.createDir(path, name);
    }

    @PostMapping("/renameFile")
    @ResponseBody
    public boolean renameFile(String path, String newName)
    {
        return service.renameFile(path, newName);
    }
}
