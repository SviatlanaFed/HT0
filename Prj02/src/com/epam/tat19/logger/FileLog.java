package com.epam.tat19.logger;
import com.epam.tat19.entity.Album;
import com.epam.tat19.entity.Artist;
import com.epam.tat19.entity.FileDetails;
import com.epam.tat19.entity.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class FileLog {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void logDuplicate(Map<String, Artist> artists ) {
        for (Artist art:artists.values()) {
            for( Album alb : art.getAlbums().values()) {
                for(Track track : alb.getTrack().values()) {
                    Map<Integer, Set<FileDetails>> fileDetails = track.getFileDetails();
                    fileDetails.forEach((length, set) -> {
                        if (set.size()>1) {
                            LOGGER.info(String.format("%s:", track.getName()));
                            for (FileDetails path : set) {
                                LOGGER.info(String.format("+ %s", path.getPath()));
                            }
                        }
                    });
                }
            }
        }
    }
    public static void logSimilar(Map<String, Artist> artists ) {
        for (Artist art:artists.values()) {
            for( Album alb : art.getAlbums().values()) {
                for(Track track : alb.getTrack().values()) {
                    Map<Integer, Set<FileDetails>> fileDetails = track.getFileDetails();
                    LOGGER.info(String.format("%s, %s, %s:", art.getName(), alb.getName(), track.getName()));
                    fileDetails.forEach((length, set) -> {
                        for (FileDetails path : set) {
                            LOGGER.info(String.format("+ %s", path.getPath()));
                        }
                    });

                }
            }
        }
    }
}
