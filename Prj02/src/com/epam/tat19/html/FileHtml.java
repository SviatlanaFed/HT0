package com.epam.tat19.html;

import com.epam.tat19.entity.*;

import java.io.*;
import java.util.Map;

public class FileHtml {
    public static void addToHtml(Map<String, Artist> artists) throws IOException {
        StringBuilder buf = new StringBuilder();
        buf.append("<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>HTML-table</title>" +
                "</head>" +
                "<body>" +
                "<ul style='list-style-type: none;'>"
        );
        for (Artist art:artists.values()) {
            buf.append("<li>")
                    .append(art.getName())
                    .append("</li>");
            for( Album alb : art.getAlbums().values()) {
                buf.append("<li>&nbsp;&nbsp;")
                        .append(alb.getName())
                        .append("</li>");

                for(Track track : alb.getTrack().values()) {
                    track.getFileDetails().forEach((length, fileDetails) -> {
                        fileDetails.forEach(path -> {
                            buf.append("<li>&nbsp;&nbsp;&nbsp;&nbsp;")
                                .append(String.format("%s - %d - %s", track.getName(), path.getLength(), path.getPath()))
                                .append("</li>");
                        });
                    });

                }
            }
        }
        buf.append("</ul>" +
                "</body>" +
                "</html>");
        String html = buf.toString();
        File file = new File("file.html");
        OutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(html);
        writer.close();
    }
}


