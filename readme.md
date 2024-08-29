# folder-cabinet-task

## Overview

This project is a simple folder management system made with Java. It allows users to manage folders and subfolders, search for folders by name or size, and count how many folders there are.

## Task Description

The main task was to create the `FolderCabinet` class with the following features:

1. **Implement the `Cabinet` interface**:
    - `Optional<Folder> findFolderByName(String name)`: Find a folder by its name.
    - `List<Folder> findFoldersBySize(String size)`: Get all folders of a certain size (SMALL, MEDIUM, LARGE).
    - `int count()`: Count the total number of folders.

2. **Use the `MultiFolder` interface**:
    - This interface allows folders to contain other folders. We need to handle this properly.

3. **Avoid Code Duplication**:
    - Keep all the logic in the `FolderCabinet` class and use Java Streams for better performance.

## Technologies and Tools Used

- Java: Oracle OpenJDK 22.0.2
- IDE: IntelliJ IDEA 2024.1.4

## Project Structure

The project is organized into different packages:

- **`com.example.cabinet`**: Contains the main class of the application.
- **`com.example.cabinet.interfaces`**: Contains the interfaces like `Cabinet`, `Folder`, and `MultiFolder`.
- **`com.example.cabinet.impl`**: Contains the implementations of folders, like `MultiFolderImpl` and `SimpleFolder`.
- **`com.example.cabinet.cabinets`**: Contains the `FileCabinet` and `FolderCabinet` classes.

## Classes

### Main
This is the starting point of the application. It creates folders and tests the features of `FolderCabinet` and `FileCabinet`.

### Cabinet Interface
This defines the main methods for managing folders.

### Folder Interface
This represents a folder with basic details like name and size.

### MultiFolder Interface
This extends the `Folder` interface to allow folders to have subfolders.

### FolderCabinet Class
This class implements the `Cabinet` interface and provides methods to search and count folders using Java Streams.

### FileCabinet Class
This is another implementation of the `Cabinet` interface that manages a list of folders without nesting.

## How to Run the Project

1. Clone the repository:
2. Compile the Java files:
```
javac -d out src/com/task/**/*.java
```
3. Run the main application:
```
java -cp out com.task.Main
```