package org.explorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileData {
    private File file;

    private String name;
    private String lastModified;
    private String type;
    private String size;
    private String path;
    private boolean isDirectory;

    public FileData(File file) {
        this.file = file;

        this.name = file.getName();

        this.lastModified = new SimpleDateFormat("dd.MM.yyyy HH:mm")
                .format(new Date(file.lastModified()));

        try {
            if (file.isDirectory()) {
                type = "Папка с файлами";
            } else {
                type = Files.probeContentType(file.toPath());
            }
        } catch (IOException ioe) {
            type = "";
        }

        try {
            this.size = String.format("% d КБ",  Files.size(file.toPath()) / 1024);
        } catch (IOException ioe) {
            this.size = "";
        }

        this.path = file.getAbsolutePath();

        this.isDirectory = file.isDirectory();
    }

    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}
