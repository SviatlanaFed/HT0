package com.epam.tat19.entity;

import java.util.HashMap;
import java.util.Map;

public class Artist implements Base {
    private String artist;
    Map<String, Album> albums=new HashMap<>();

    public Artist(String artist, Map<String, Album> albums) {
        this.artist = artist;
        this.albums = albums;
    }

    public Artist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Map<String, Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album title) {
        albums.putIfAbsent(title.getName(), title);
    }
}
