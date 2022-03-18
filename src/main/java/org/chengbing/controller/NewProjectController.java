package org.chengbing.controller;

import org.chengbing.service.NewProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newProject")
public class NewProjectController {

    @Autowired
    NewProjectService service;

    @PostMapping("/java")
    public boolean createNewJavaProject(String name, String path)
    {
        return service.createNewJavaProject(name, path);
    }
    @PostMapping("/maven")
    public boolean createNewMavenProject(String name, String path, String groupId)
    {
        return service.createNewMavenProject(name, path, groupId);
    }
    @PostMapping("/spring")
    public boolean createNewSpringProject(String name, String path, String groupId)
    {
        return service.createNewSpringProject(name, path, groupId);
    }
}
