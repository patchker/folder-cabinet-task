package org.task.cabinets;

import org.task.interfaces.Cabinet;
import org.task.interfaces.Folder;
import org.task.interfaces.MultiFolder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FolderCabinet implements Cabinet {
    private List<Folder> folders;

    public FolderCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return getAllFolders()
                .filter(folder -> folder.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return getAllFolders()
                .filter(folder -> folder.getSize().equals(size))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) getAllFolders().count();
    }

    private Stream<Folder> getAllFolders() {
        return folders.stream().flatMap(this::flattenFolder);
    }

    private Stream<Folder> flattenFolder(Folder folder) {
        if (folder instanceof MultiFolder) {
            MultiFolder multiFolder = (MultiFolder) folder;
            return Stream.concat(
                    Stream.of(folder),
                    multiFolder.getFolders().stream().flatMap(this::flattenFolder)
            );
        }
        return Stream.of(folder);
    }
}