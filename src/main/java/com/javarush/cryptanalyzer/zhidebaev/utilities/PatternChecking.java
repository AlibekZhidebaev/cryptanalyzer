package com.javarush.cryptanalyzer.zhidebaev.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternChecking {
    Pattern pattern;
    Matcher matcher;
    private String regex = "([а-яёА-ЯЁ]+(\\s|,\\s|.\\s|:\\s|\\s-\\s)){3,}";
    StringBuilder text = new StringBuilder();
    private boolean patternIsValid = false;

    public boolean getPatternIsValid(String texts) {
        text.append(texts);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) patternIsValid = true;
        return patternIsValid;
    }
}
