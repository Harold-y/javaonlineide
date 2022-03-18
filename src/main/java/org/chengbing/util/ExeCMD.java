package org.chengbing.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExeCMD {
    public static String exec(String command)
    {
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime(); //得到本程序
        try {
            Process process = runtime.exec(command);  //该实例可用来控制进程并获得相关信息
            process.waitFor();
            //获取进程输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null)
                sb.append(line + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ExeCMD.exec("cmd /c start cmd.exe"));

    }
}
