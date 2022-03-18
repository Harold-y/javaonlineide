package org.chengbing.util;

import org.chengbing.entity.FileGeneral;
import org.chengbing.entity.Folder;
import org.chengbing.enums.Types;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class SearchFileUtil {

    @Value("${project.path}")
    String rootPath;


    public Folder search(String path)
    {
        File f = new File(path);
        String nameF = f.getName();
        int numChildren = Objects.requireNonNull(f.list()).length;
        ArrayList<Object> list = helper(path);
        return new Folder(nameF, path, numChildren, list);
    }


    public ArrayList<Object> helper(String path)
    {
        ArrayList<Object> list = new ArrayList<>();
        File f = new File(path);
        File[] rootFiles = f.listFiles();
        if(rootFiles != null)
            for(File file : rootFiles)
            {
                if(file.isDirectory())
                {
                    list.add(search(file.getPath()));
                }else if (file.isFile())
                {
                    String name = file.getName();
                    String[] suffixArr = name.split("\\.");
                    String suffix;
                    if(suffixArr.length == 0)
                        suffix = "";
                    else
                        suffix = suffixArr[suffixArr.length - 1];
                    list.add(new FileGeneral(name, file.getPath(), suffix));
                }
            }
        return list;
    }


    public String getRootPath()
    {
        return rootPath;
    }


    public static void main(String[] args) {
        SearchFileUtil util = new SearchFileUtil();
        Folder fg = util.search("D:/Programming/IdeaProjects/P01 COVID");
        System.out.println(fg);
    }
}
