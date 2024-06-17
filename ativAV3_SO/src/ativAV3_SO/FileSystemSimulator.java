package ativAV3_SO;

import java.util.ArrayList;
import java.util.List;

public class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        this.root = new Directory("root");
        this.journal = new Journal();
    }

    public void createFile(String path, String fileName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            File file = new File(fileName);
            dir.addFile(file);
            journal.record("Created file: " + fileName + " in directory: " + path);
        }
    }

    public void deleteFile(String path, String fileName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            dir.removeFile(fileName);
            journal.record("Deleted file: " + fileName + " from directory: " + path);
        }
    }

    public void renameFile(String path, String oldName, String newName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            File file = dir.getFile(oldName);
            if (file != null) {
                file.setName(newName);
                journal.record("Renamed file: " + oldName + " to: " + newName + " in directory: " + path);
            }
        }
    }

    public void createDirectory(String path, String dirName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            Directory newDir = new Directory(dirName);
            dir.addDirectory(newDir);
            journal.record("Created directory: " + dirName + " in directory: " + path);
        }
    }

    public void deleteDirectory(String path, String dirName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            dir.removeDirectory(dirName);
            journal.record("Deleted directory: " + dirName + " from directory: " + path);
        }
    }

    public void renameDirectory(String path, String oldName, String newName) {
        Directory dir = getDirectory(path);
        if (dir != null) {
            Directory subDir = dir.getDirectory(oldName);
            if (subDir != null) {
                subDir.setName(newName);
                journal.record("Renamed directory: " + oldName + " to: " + newName + " in directory: " + path);
            }
        }
    }

    public List<String> listFiles(String path) {
        Directory dir = getDirectory(path);
        List<String> fileNames = new ArrayList<>();
        if (dir != null) {
            fileNames.addAll(dir.getFiles().keySet());
            for (String dirName : dir.getDirectories().keySet()) {
                fileNames.add("[" + dirName + "]");
            }
        }
        return fileNames;
    }

    private Directory getDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (!part.isEmpty()) {
                current = current.getDirectory(part);
                if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }
}



