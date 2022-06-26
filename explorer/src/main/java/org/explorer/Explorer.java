package org.explorer;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
public class Explorer {

    private File dir;

    private ArrayList<FileData> filesData = new ArrayList<>();

    private boolean isRoot;

    private boolean isDisk;

    public Explorer() {
        this(System.getProperty("user.dir"));
    }

    public Explorer(String pathString) {
        this.dir = new File(pathString);

        try {
            for (File file : dir.listFiles()) {
                if (!file.isHidden() && file.exists()) {
                    this.filesData.add(new FileData(file));
                }
            }
        } catch (NullPointerException npe) {

        }

        this.isRoot = dir.toPath().getNameCount() == 0;

        this.isDisk = false;
    }

    public Explorer(File[] files) {
        this.dir = new File("");

        for (File file : files) {
            this.filesData.add(new FileData(file));
        }

        this.isDisk = true;
    }

    public File getDir() {
        return dir;
    }

    public ArrayList<FileData> getFilesData() {
        return filesData;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public boolean isDisk() {
        return isDisk;
    }
}
