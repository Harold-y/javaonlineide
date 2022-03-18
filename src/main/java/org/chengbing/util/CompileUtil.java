package org.chengbing.util;
import java.io.*;

public class CompileUtil {

    static String OS = System.getProperty("os.name").toLowerCase();

    public static String commonCompile(String path, String input) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        String[] command0 = new String[0];
        String[] command = new String[0];
        //System.out.println(path);
        if (isUnix()) {
            // get javac to target folder
            String[] arr = path.split("/");
            String pathBeforeTarget = "";
            String targetPath = "";
            String filePath = "";
            String packagePath = "";
            boolean found = false;
            for(String s : arr)
            {
                if(!found)
                {
                    if(!s.equals("src"))
                    {
                        pathBeforeTarget += s + "/";
                    }else
                    {
                        found = true;
                    }
                }else
                {
                    filePath += s + "/";
                    if(!s.equals("src"))
                    {
                        packagePath += s + ".";
                    }
                }
            }
            packagePath = packagePath.substring(0, packagePath.length() - 1).replaceFirst(".java", "");
            targetPath = pathBeforeTarget + "target";

            filePath = filePath.substring(0, filePath.length() - 1);
/*            System.out.println("Target Path: " + targetPath);
            System.out.println("pathBeforeTarget: " + pathBeforeTarget);
            System.out.println("filePath: " + filePath);
            System.out.println("packagePath: " + packagePath);*/
            /*
            Target Path: /home/ubuntu/test/testShell/target
            pathBeforeTarget: /home/ubuntu/test/testShell/
            filePath: entity/Hello.java
            packagePath: entity.Hello
             && java entity.Hello: line 0: cd: /home/ubuntu/test/testShell/target : No such file or directory
             */
            File f = new File(targetPath);
            if(!f.exists())
                f.mkdirs();
            // Create a new process and run the command
            command0 = new String[]{"/bin/bash","-c", "cd " + pathBeforeTarget + " && javac -d target src/"+filePath};
            command = new String[]{"/bin/bash","-c", "cd "+targetPath + " && java " + packagePath}; // Can also directly be put into the process builder as an argument without it being in an array
        } else if (isWindows()) {
            // get javac to target folder
            String[] arr = path.split("\\\\");
            String pathBeforeTarget = "";
            String targetPath = "";
            String filePath = "";
            String packagePath = "";
            boolean found = false;
            for(String s : arr)
            {
                if(!found)
                {
                    if(!s.equals("src"))
                    {
                        pathBeforeTarget += s + "\\";
                    }else
                    {
                        found = true;
                    }
                }else
                {
                    filePath += s + "\\";
                    if(!s.equals("src"))
                    {
                        packagePath += s + ".";
                    }
                }
            }
            packagePath = packagePath.substring(0, packagePath.length() - 1).replaceFirst(".java", "");
            targetPath = pathBeforeTarget + "target";

            filePath = filePath.substring(0, filePath.length() - 1);
            /*System.out.println("Target Path: " + targetPath);
            System.out.println("pathBeforeTarget: " + pathBeforeTarget);
            System.out.println("filePath: " + filePath);
            System.out.println("packagePath: " + packagePath);*/

            File f = new File(targetPath);
            if(!f.exists())
                f.mkdirs();
            // Create a new process and run the command
            command0 = new String[]{"cmd", "/c", "cd /d \"" + pathBeforeTarget + "\""," && javac -d target src\\"+filePath};
            command = new String[]{"cmd", "/c", "cd /d \""+targetPath+" \"", " && java " + packagePath}; // Can also directly be put into the process builder as an argument without it being in an array
        }
        Runtime runtime = Runtime.getRuntime(); //得到本程序
        Process process0 = runtime.exec(command0);  //该实例可用来控制进程并获得相关信息

        InputStream stderr1 = process0.getInputStream();
        BufferedReader error1 = new BufferedReader(new InputStreamReader(stderr1));
        String line1;
        while ((line1 = error1.readLine()) != null) builder.append(line1).append('\n');

        InputStream stderr0 = process0.getErrorStream();
        BufferedReader error0 = new BufferedReader(new InputStreamReader(stderr0));
        String line0;
        while ((line0 = error0.readLine()) != null) builder.append(line0).append('\n');

               /*process0.waitFor();
               ProcessBuilder builder = new ProcessBuilder(command);*/
        Process process = runtime.exec(command);
        OutputStream stdin = process.getOutputStream();
        InputStream stdout = process.getInputStream();
        InputStream stderr = process.getErrorStream();

        // Store the input and output streams in a buffer
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
        BufferedReader error = new BufferedReader(new InputStreamReader(stderr));
        if(input != null && !input.equals(""))
        {
            // Send input
            writer.write(input); // Don't forget the '\n' here, otherwise it'll continue to wait for input
            writer.flush();
            //writer.close(); // Add if doesn't work without it
        }
        // Display the output
        String line;
        while ((line = reader.readLine()) != null) builder.append(line).append('\n');
        // Display any errors
        while ((line = error.readLine()) != null) builder.append(line).append('\n');

        return builder.toString();
    }

    public String dependencyCompile(String path)
    {
        return null;
    }

    public static String mavenCompile(String path)
    {
        return null;
    }

    public static String springCompile(String path)
    {
        return null;
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Harold Y\\IdeaProjects\\testWeb\\src\\entity\\Weapon.java";
        try {
            System.out.println(commonCompile(path, ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
