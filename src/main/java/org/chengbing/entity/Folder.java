package org.chengbing.entity;

import lombok.Data;
import org.chengbing.enums.Types;

import java.util.ArrayList;

@Data
public class Folder{
    String fileName;
    String path;
    Integer numChildren;
    String type = "folder";
    boolean isOpen;
    ArrayList<Object> folderContainer;

    public Folder() {
    }

    public Folder(String fileName, String path, Integer numChildren) {
        this.fileName = fileName;
        this.path = path;
        this.numChildren = numChildren;
    }

    public Folder(String fileName, String path, Integer numChildren, ArrayList<Object> folderContainer) {
        this.fileName = fileName;
        this.path = path;
        this.numChildren = numChildren;
        this.folderContainer = folderContainer;
    }

    public Folder(String fileName, String path, Integer numChildren, boolean isOpen, ArrayList<Object> folderContainer) {
        this.fileName = fileName;
        this.path = path;
        this.numChildren = numChildren;
        this.isOpen = isOpen;
        this.folderContainer = folderContainer;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", numChildren=" + numChildren +
                ", isOpen=" + isOpen +
                ", folderContainer=" + folderContainer +
                '}';
    }
}
