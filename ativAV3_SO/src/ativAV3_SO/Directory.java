package ativAV3_SO;

import java.util.HashMap;

public class Directory {
    private String name;
    private HashMap<String, File> files;
    private HashMap<String, Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.put(file.getName(), file);
    }

    public void removeFile(String fileName) {
        files.remove(fileName);
    }

    public File getFile(String fileName) {
        return files.get(fileName);
    }

    public void addDirectory(Directory directory) {
        directories.put(directory.getName(), directory);
    }

    public void removeDirectory(String dirName) {
        directories.remove(dirName);
    }

    public Directory getDirectory(String dirName) {
        return directories.get(dirName);
    }

    public HashMap<String, File> getFiles() {
        return files;
    }

    public HashMap<String, Directory> getDirectories() {
        return directories;
    }
}



