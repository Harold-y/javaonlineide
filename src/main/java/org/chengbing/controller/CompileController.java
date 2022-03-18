package org.chengbing.controller;

import org.chengbing.service.CompileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/compile")
public class CompileController {

    @Autowired
    CompileService service;

    @PostMapping("/compile")
    @ResponseBody
    public String commonCompile(String path, String input) throws IOException {
        return service.commonCompile(path, input);
    }

    @PostMapping("/mavenCompile")
    @ResponseBody
    public String mavenCompile(String path)
    {
        return service.mavenCompile(path);
    }
    @PostMapping("/springCompile")
    @ResponseBody
    public String springCompile(String path)
    {
        return service.springCompile(path);
    }
}
