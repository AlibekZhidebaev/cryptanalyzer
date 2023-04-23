package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecking {
    static private boolean patternIsValid = false;
    static private final StringBuilder text = new StringBuilder();

    // -- Метод проверки строки на соответствие регулярному выражению --
    public static boolean getPatternIsValid(String texts) {
        text.append(texts);
        String regex = FileConstants.REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) patternIsValid = true;
        return patternIsValid;
    }
}
