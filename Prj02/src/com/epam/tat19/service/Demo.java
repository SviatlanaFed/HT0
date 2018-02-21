package com.epam.tat19.service;

import com.epam.tat19.entity.Artist;
import com.epam.tat19.html.FileHtml;
import com.epam.tat19.logger.FileLog;
import com.epam.tat19.validator.Validator;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws IOException {
        if (args.length==0) {
            System.out.println("You are not entered params. You must enter file path .");
            return;
        }
        for (int i=0;i<args.length;i++) {
            if (Validator.checkPath(args[i])) {
                System.out.println("You are entered incorrect file path");
                return;
            }
        }
        String fileType = "mp3";
        Map<String, Artist> lib = FileSearching.getFileFromFolder(new File(args[0]), fileType);
        FileHtml.addToHtml(lib);
        FileLog.logDuplicate(lib);
        FileLog.logSimilar(lib);
    }
}
