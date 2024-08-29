package org.task.interfaces;

import java.util.List;

public interface MultiFolder extends Folder {
    List<Folder> getFolders();
}