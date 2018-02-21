package com.epam.tat19.service;

import com.epam.tat19.entity.*;
import org.jd3lib.MP3File;
import org.jd3lib.MetaData;

import java.io.File;
import java.util.*;

public class FileSearching {


    public static Map<String, Artist> getFileFromFolder(File filePath, String filetype) {
        HashMap<String, Artist> artists = new HashMap<>();
        File[] dir = filePath.listFiles();
        for (File item : dir) {
            if (item.isDirectory()) {
                getFileFromFolder(item, filetype);
                continue;
            }
            if (item.getName().endsWith(filetype)) {
                MP3File mp3File = new MP3File(item.getAbsolutePath());
                MetaData metaData = mp3File.getMetaData();
                Album albumNew = new Album(unknownIfEmpty(metaData.getAlbum()));
                Artist artistNew = new Artist(unknownIfEmpty(metaData.getArtist()));
                Track trackNew=new Track(unknownIfEmpty(metaData.getTitle()));
                FileDetails path=new FileDetails(item.getAbsolutePath(), (int)item.length());

                artists.putIfAbsent(artistNew.getName(), artistNew);
                Artist artist = artists.get(artistNew.getName());

                artist.getAlbums().putIfAbsent(albumNew.getName(), albumNew);
                Album album = artist.getAlbums().get(albumNew.getName());

                album.getTrack().putIfAbsent(trackNew.getName(), trackNew);
                Track track = album.getTrack().get(trackNew.getName());
                track.addFilePath(path);
            }
        }
        return artists;
    }
    protected static String unknownIfEmpty (String str){
        return str == null || str.isEmpty() ? "unknown" : str;
    }

    protected static boolean contains(Set<? extends Base> set, Base val) {
        for (Base curr : set) {
            if (curr.getName().equals(val)) {
                return true;
            }
        }
        return false;
    }
}

