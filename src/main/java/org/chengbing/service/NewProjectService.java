package org.chengbing.service;

import org.apache.commons.io.FileUtils;
import org.chengbing.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class NewProjectService {

    @Autowired
    HistoryDao historyDao;

    @Autowired
    HistoryService service;

    public boolean createNewJavaProject(String name, String path)
    {
        boolean condition = true;
        File f = new File(path + System.getProperty("file.separator") + name);
        if(!f.exists())
            condition = f.mkdirs();
        File src = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src");
        if(!src.exists())
            condition = condition && src.mkdirs();
        File resource = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "resource");
        if(!resource.exists())
            condition = condition && resource.mkdirs();
        if(condition)
        {
            service.insertProject(path+ System.getProperty("file.separator") + name, name, "java");
        }
        return condition;
    }

    public boolean createNewMavenProject(String name, String path, String groupId)
    {
        boolean condition = true;
        // root
        File f = new File(path + System.getProperty("file.separator") + name);
        if(!f.exists())
            condition = f.mkdirs();
        // root -> src
        File src = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src");
        if(!src.exists())
            condition = condition && src.mkdirs();
        // root -> src -> main
        File main = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main");
        if(!main.exists())
            condition = condition && main.mkdirs();
        // root -> src -> main -> java
        File mainJava = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "java");
        if(!mainJava.exists())
            condition = condition && mainJava.mkdirs();
        // root -> src -> main -> resource
        File resource = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "resource");
        if(!resource.exists())
            condition = condition && resource.mkdirs();
        // root -> src -> test
        File test = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test");
        if(!test.exists())
            condition = condition && test.mkdirs();
        // root -> src -> test -> java
        File testJava = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test"+ System.getProperty("file.separator") + "java");
        if(!testJava.exists())
            condition = condition && testJava.mkdirs();
        // root -> pom.xml
        File pom = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "pom.xml");
        if(!pom.exists()) {
            try {
                condition = condition && pom.createNewFile();
                String pomContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n" +
                        "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                        "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                        "    <modelVersion>4.0.0</modelVersion>\n" +
                        "\n" +
                        "    <groupId>"+groupId+"</groupId>\n" +
                        "    <artifactId>"+name+"</artifactId>\n" +
                        "    <version>1.0-SNAPSHOT</version>\n" +
                        "\n" +
                        "    <properties>\n" +
                        "        <maven.compiler.source>11</maven.compiler.source>\n" +
                        "        <maven.compiler.target>11</maven.compiler.target>\n" +
                        "    </properties>\n" +
                        "\n" +
                        "</project>";
                FileUtils.writeStringToFile(pom, pomContent, "UTF-8", false);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(condition)
        {
            service.insertProject(path+ System.getProperty("file.separator") + name, name, "maven");
        }
        return condition;
    }

    public boolean createNewSpringProject(String name, String path, String groupId)
    {
        boolean condition = true;
        // root
        File f = new File(path + System.getProperty("file.separator") + name);
        if(!f.exists())
            condition = f.mkdirs();
        // root -> src
        File src = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src");
        if(!src.exists())
            condition = condition && src.mkdirs();
        // root -> src -> main
        File main = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main");
        if(!main.exists())
            condition = condition && main.mkdirs();
        // root -> src -> main -> java
        File mainJava = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "java");
        if(!mainJava.exists())
            condition = condition && mainJava.mkdirs();
        // root -> src -> main -> java -> GroupID, name, servletInitializer,Application
        String[] groupIdFolders = groupId.split("\\.");
        String currentStatus = path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "java";
        for(String s : groupIdFolders)
        {
            currentStatus += System.getProperty("file.separator") + s;
            File mainJavaGroupID = new File(currentStatus);
            if(!mainJavaGroupID.exists())
                condition = condition && mainJavaGroupID.mkdirs();
        }
        File mainJavaGroupIDName = new File(currentStatus + System.getProperty("file.separator") + name);
        if(!mainJavaGroupIDName.exists())
            condition = condition && mainJavaGroupIDName.mkdirs();
        File ServletInitializer = new File(currentStatus + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "ServletInitializer.java");
        if(!ServletInitializer.exists()) {
            try {
                condition = condition && ServletInitializer.createNewFile();
                String svContent = "package "+groupId+"."+name+";\n" +
                        "\n" +
                        "import org.springframework.boot.builder.SpringApplicationBuilder;\n" +
                        "import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;\n" +
                        "import "+groupId+"."+name+"Application;"+
                        "\n" +
                        "public class ServletInitializer extends SpringBootServletInitializer {\n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {\n" +
                        "        return application.sources("+name+"Application.class);\n" +
                        "    }\n" +
                        "}\n";
                FileUtils.writeStringToFile(ServletInitializer, svContent, "UTF-8", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File application = new File(currentStatus + System.getProperty("file.separator") + name+"Application.java");
        if(!application.exists()) {
            try {
                condition = condition && application.createNewFile();
                String applicationContent = "package "+groupId+";\n" +
                        "\n" +
                        "import org.springframework.boot.SpringApplication;\n" +
                        "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                        "\n" +
                        "@SpringBootApplication\n" +
                        "public class "+name+"Application {\n" +
                        "\n" +
                        "    public static void main(String[] args) {\n" +
                        "        SpringApplication.run("+name+"Application.class, args);\n" +
                        "    }\n" +
                        "\n" +
                        "}";
                FileUtils.writeStringToFile(application, applicationContent, "UTF-8", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // root -> src -> main -> resource
        File resource = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "resource");
        if(!resource.exists())
            condition = condition && resource.mkdirs();
        // root -> src -> main -> resource -> static
        File resourceStatic = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "resource"
                + System.getProperty("file.separator") + "static");
        if(!resourceStatic.exists())
            condition = condition && resourceStatic.mkdirs();
        // root -> src -> main -> resource -> static
        File resourceTemplate = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "resource"
                + System.getProperty("file.separator") + "templates");
        if(!resourceTemplate.exists())
            condition = condition && resourceTemplate.mkdirs();
        // root -> src -> main -> resource -> application.properties
        File resourceAppProp = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "main"+ System.getProperty("file.separator") + "resource"
                + System.getProperty("file.separator") + "application.properties");
        if(!resourceAppProp.exists()) {
            try {
                condition = condition && resourceAppProp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        // root -> src -> test
        File test = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test");
        if(!test.exists())
            condition = condition && test.mkdirs();
        // root -> src -> test -> java
        File testJava = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "test"+ System.getProperty("file.separator") + "java");
        if(!testJava.exists())
            condition = condition && testJava.mkdirs();
        // root -> pom.xml
        File pom = new File(path + System.getProperty("file.separator") + name + System.getProperty("file.separator") + "pom.xml");
        if(!pom.exists()) {
            try {
                condition = condition && pom.createNewFile();
                String pomContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                        "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                        "    <modelVersion>4.0.0</modelVersion>\n" +
                        "    <parent>\n" +
                        "        <groupId>org.springframework.boot</groupId>\n" +
                        "        <artifactId>spring-boot-starter-parent</artifactId>\n" +
                        "        <version>2.6.4</version>\n" +
                        "        <relativePath/> <!-- lookup parent from repository -->\n" +
                        "    </parent>\n" +
                        "    <groupId>"+groupId+"</groupId>\n" +
                        "    <artifactId>"+name+"</artifactId>\n" +
                        "    <version>0.0.1-SNAPSHOT</version>\n" +
                        "    <packaging>war</packaging>\n" +
                        "    <name>"+name+"</name>\n" +
                        "    <description>descr</description>\n" +
                        "    <properties>\n" +
                        "        <java.version>11</java.version>\n" +
                        "    </properties>\n" +
                        "    <dependencies>\n" +
                        "        <dependency>\n" +
                        "            <groupId>org.springframework.boot</groupId>\n" +
                        "            <artifactId>spring-boot-starter-web</artifactId>\n" +
                        "        </dependency>\n" +
                        "\n" +
                        "        <dependency>\n" +
                        "            <groupId>org.springframework.boot</groupId>\n" +
                        "            <artifactId>spring-boot-starter-tomcat</artifactId>\n" +
                        "            <scope>provided</scope>\n" +
                        "        </dependency>\n" +
                        "        <dependency>\n" +
                        "            <groupId>org.springframework.boot</groupId>\n" +
                        "            <artifactId>spring-boot-starter-test</artifactId>\n" +
                        "            <scope>test</scope>\n" +
                        "        </dependency>\n" +
                        "    </dependencies>\n" +
                        "\n" +
                        "    <build>\n" +
                        "        <plugins>\n" +
                        "            <plugin>\n" +
                        "                <groupId>org.springframework.boot</groupId>\n" +
                        "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
                        "            </plugin>\n" +
                        "        </plugins>\n" +
                        "    </build>\n" +
                        "\n" +
                        "</project>";
                FileUtils.writeStringToFile(pom, pomContent, "UTF-8", false);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(condition)
        {
            service.insertProject(path+ System.getProperty("file.separator") + name, name, "spring");
        }
        return condition;
    }
}
