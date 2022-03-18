package org.chengbing.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileOperationService {

    public String getBase64Image(String path)
    {
        try {
            File file = new File(path);
            if(file.exists() && file.isFile())
            {
                InputStream finput = new FileInputStream(file);
                byte[] imageBytes = new byte[(int)file.length()];
                finput.read(imageBytes, 0, imageBytes.length);
                finput.close();
                return Base64.encodeBase64String(imageBytes);
            }
        } catch (Exception e)
        {
            System.out.println("Exception Occurred At FileOperation Class");
            e.printStackTrace();
        }
        return "NA";
    }

    public String getFileContent(String path)
    {
        try {
            File file = new File(path);
            if(file.exists() && file.isFile())
            {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader);
                StringBuilder builder = new StringBuilder();
                String text = null;
                while ((text = bufferedReader.readLine()) != null)
                    builder.append(text).append("\n");
                bufferedReader.close();
                reader.close();
                return builder.toString();
            }
        } catch (Exception e)
        {
            System.out.println("Exception Occurred At FileOperation Class");
            e.printStackTrace();
        }
        return "NA";
    }

    public int updateFileContent(String path, String content)
    {
        try {
            File file = new File(path);
            FileUtils.writeStringToFile(file, content, "UTF-8", false);
            return 0;
        } catch (Exception e)
        {
            System.out.println("Exception Occurred At FileOperation Class");
            e.printStackTrace();
        }
        return -1;
    }

    public int updateFileContent2(String path, String content)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(content);
            writer.close();
            return 0;
        } catch (Exception e)
        {
            System.out.println("Exception Occurred At FileOperation Class");
            e.printStackTrace();
        }
        return -1;
    }

    public boolean deleteFile(String path)
    {
        File f = new File(path);
        if(f.exists() && f.isDirectory()) {
            try {
                FileUtils.deleteDirectory(f);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else
            return f.delete();
        return true;
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

    public boolean createDir(String path, String name)
    {
        File f = new File(path + "/" + name);
        if(f.exists() && f.isDirectory())
            return false;
        return f.mkdir();
    }

    public boolean renameFile(String path, String newName)
    {
        System.out.println(path);
        System.out.println(newName);
        File f = new File(path);
        Path path1 = Paths.get(path);
        Path parentPath = path1.getParent();
        String parentName = parentPath.toString();
        if(!f.exists())
            return false;
        return f.renameTo(new File(parentName + "/" + newName));
    }

}
