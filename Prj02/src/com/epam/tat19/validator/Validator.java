package com.epam.tat19.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean checkPath(String filePath){
        Pattern pattern=Pattern.compile("^[A-Z]{1}[:]{1}\\\\\\\\{1}[A-Za-zА-Яа-я0-9]{1,20}[/]?$");
        Matcher matcher=pattern.matcher(filePath);
        return matcher.find();
    }


}
