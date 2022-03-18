package org.chengbing.service;
import org.chengbing.util.CompileUtil;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class CompileService {

    public String commonCompile(String path, String input) throws IOException
    {
        return CompileUtil.commonCompile(path, input + "\n");
    }

    public String mavenCompile(String path)
    {
        return null;
    }

    public String springCompile(String path)
    {
        return null;
    }
}
