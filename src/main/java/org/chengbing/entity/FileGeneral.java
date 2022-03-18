package org.chengbing.entity;

import lombok.Data;
import org.chengbing.enums.Types;


@Data
public class FileGeneral {
    String fileName;
    String path;
    String type;

    public FileGeneral() {
    }

    public FileGeneral(String fileName, String path, String type) {
        this.fileName = fileName;
        this.path = path;
        this.type = type;
    }

    @Override
    public String toString() {
        return "FileGeneral{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", type=" + type +
                '}';
    }
}
