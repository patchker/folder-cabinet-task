package org.task;

import org.task.cabinets.FileCabinet;
import org.task.cabinets.FolderCabinet;
import org.task.impl.FolderImpl;
import org.task.impl.MultiFolderImpl;
import org.task.interfaces.Cabinet;
import org.task.interfaces.Folder;
import org.task.interfaces.MultiFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Folder folder1 = new FolderImpl("Music", "SMALL");
        Folder folder2 = new FolderImpl("Documents", "MEDIUM");
        Folder folder3 = new FolderImpl("Pictures", "LARGE");

        List<Folder> subFolders = new ArrayList<>();
        subFolders.add(new FolderImpl("Vacation", "MEDIUM"));
        subFolders.add(new FolderImpl("Family", "SMALL"));

        MultiFolder multiFolder = new MultiFolderImpl("Photos", "LARGE", subFolders);

        List<Folder> folders = new ArrayList<>();
        folders.add(folder1);
        folders.add(folder2);
        folders.add(folder3);
        folders.add(multiFolder);

        FolderCabinet folderCabinet = new FolderCabinet(folders);

        FileCabinet fileCabinet = new FileCabinet();
        fileCabinet.addFolder(folder1);
        fileCabinet.addFolder(folder2);
        fileCabinet.addFolder(folder3);
        fileCabinet.addFolder(multiFolder);

        testFindFolderByName(folderCabinet, fileCabinet);
        testFindFoldersBySize(folderCabinet, fileCabinet);
        testCount(folderCabinet, fileCabinet);
    }

    private static void testFindFolderByName(FolderCabinet folderCabinet, FileCabinet fileCabinet) {
        String nameToFind = "Pictures";
        testFindFolderByNameForCabinet(folderCabinet, nameToFind);
        testFindFolderByNameForCabinet(fileCabinet, nameToFind);
    }

    private static void testFindFolderByNameForCabinet(Cabinet cabinet, String nameToFind) {
        Optional<Folder> foundFolder = cabinet.findFolderByName(nameToFind);
        System.out.println("Wynik wyszukiwania folderu o nazwie '" + nameToFind + "' w " + cabinet.getClass().getSimpleName() + ": " +
                (foundFolder.isPresent() ? "Znaleziono: " + foundFolder.get().getName() : "Nie znaleziono"));
    }

    private static void testFindFoldersBySize(FolderCabinet folderCabinet, FileCabinet fileCabinet) {
        String sizeToFind = "MEDIUM";
        testFindFoldersBySizeForCabinet(folderCabinet, sizeToFind);
        testFindFoldersBySizeForCabinet(fileCabinet, sizeToFind);
    }

    private static void testFindFoldersBySizeForCabinet(Cabinet cabinet, String sizeToFind) {
        List<Folder> foundFolders = cabinet.findFoldersBySize(sizeToFind);
        System.out.println("Foldery o rozmiarze '" + sizeToFind + "' w " + cabinet.getClass().getSimpleName() + ":");
        foundFolders.forEach(folder -> System.out.println(" - " + folder.getName()));
    }

    private static void testCount(FolderCabinet folderCabinet, FileCabinet fileCabinet) {
        testCountForCabinet(folderCabinet);
        testCountForCabinet(fileCabinet);
    }

    private static void testCountForCabinet(Cabinet cabinet) {
        int totalCount = cabinet.count();
        System.out.println("Całkowita liczba folderów w " + cabinet.getClass().getSimpleName() + ": " + totalCount);
    }
}
