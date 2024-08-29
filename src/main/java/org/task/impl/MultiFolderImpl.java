package org.task.impl;

import org.task.interfaces.Folder;
import org.task.interfaces.MultiFolder;

import java.util.List;

public class MultiFolderImpl implements MultiFolder {
    private String name;
    private String size;
    private List<Folder> folders;

    public MultiFolderImpl(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = folders;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public List<Folder> getFolders() {
        return folders;
    }
}