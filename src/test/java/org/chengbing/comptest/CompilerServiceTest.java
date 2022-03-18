package org.chengbing.comptest;

import org.chengbing.service.CompileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class CompilerServiceTest {

    @Resource
    CompileService service;

    @Test
    public void test1()
    {
        try {
            String s = service.commonCompile("C:\\Users\\Harold Y\\IdeaProjects\\testWeb\\src\\entity\\Weapon.java", "");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
