package com.epam.tat19.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Album implements Base {
    private String album;
    Map<String, Track> track=new HashMap<>();

    public Album(String album) {
        this.album = album;
    }

    public String getName() {
        return album;
    }

    public Map<String, Track> getTrack() {
        return track;
    }
}
