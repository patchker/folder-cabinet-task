package org.task.cabinets;

import org.task.interfaces.Cabinet;
import org.task.interfaces.Folder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class FileCabinet implements Cabinet {
    private List<Folder> folders;

    public FileCabinet() {
        this.folders = new ArrayList<>();
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return folders.stream()
                .filter(folder -> folder.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return folders.stream()
                .filter(folder -> folder.getSize().equals(size))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return folders.size();
    }
}