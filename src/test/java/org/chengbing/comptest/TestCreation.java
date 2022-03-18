package org.chengbing.comptest;

import org.chengbing.service.NewProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestCreation {

    @Resource
    NewProjectService service;

    @Test
    public void testJava()
    {
        service.createNewSpringProject("aaaSpringTest1", "C:\\Users\\Harold Y\\IdeaProjects", "bigdan");
    }
}
