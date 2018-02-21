package com.epam.tat19.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Track implements Base {
    private String title;
    Map<Integer, Set<FileDetails>> fileDetails =new HashMap<>();

    public Track(String title, Map<Integer, Set<FileDetails>> fileDetails) {
        this.title = title;
        this.fileDetails = fileDetails;
    }

    public Track(String title) {
        this.title = title;
    }

    public String getName() {
        return title;
    }

    public Map<Integer, Set<FileDetails>> getFileDetails() {
        return fileDetails;
    }

    public void addFilePath(FileDetails path) {
        fileDetails.putIfAbsent(path.getLength(), new HashSet<>());
        fileDetails.get(path.getLength()).add(path);
    }

}
