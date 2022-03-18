package org.chengbing.test;

import org.chengbing.service.FileOperationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class TestFile1 {
    @Resource
    FileOperationService service;
    public boolean createDir(String path, String name)
    {
        File f = new File(path + "/" + name);
        if(f.exists() && f.isDirectory())
            return false;
        return f.mkdir();
    }
    public boolean createFile(String path, String name)
    {
        File f = new File(path + "/" + name);
        if(f.exists())
            return false;
        try {
            return f.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteFile(String path)
    {
        File f = new File(path);
        if (f.exists())
            return f.delete();
        return false;
    }

    public boolean renameFile(String path, String parentPath, String newName)
    {
        File f = new File(path);
        if(!f.exists())
            return false;
        return f.renameTo(new File(parentPath + "/" + newName));
    }


    public static void main(String[] args) {
        String path = "D:\\Programming\\IdeaProjects\\P01 COVID\\src";
        String name = "testDir";
        String newName = "renamedDir";
        TestFile1 testFile1 = new TestFile1();
        System.out.println( testFile1.deleteFile("C:\\Users\\Harold Y\\IdeaProjects\\wd\\out\\haha"));;
    }
}
