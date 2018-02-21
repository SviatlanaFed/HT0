package com.epam.tat19.entity;

public class FileDetails {
    private String path;
    private int length;

    public FileDetails(String path, int length) {
        this.path = path;
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public int getLength() {
        return this.length;
    }
}
