package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecking {
    private String regex = FileConstants.REGEX;
    private boolean patternIsValid = false;
    private StringBuilder text = new StringBuilder();

    // -- Метод проверки строки на соответствие регулярному выражению --
    public boolean getPatternIsValid(String texts) {
        text.append(texts);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) patternIsValid = true;
        return patternIsValid;
    }
}
