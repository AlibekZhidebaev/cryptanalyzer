package com.javarush.cryptanalyzer.zhidebaev.constants;

import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;

public final class FileConstants {
    private static final String DIRECTORY = "text";
    private static final String SLASH = "//";
    private static final String INPUT = "input.txt";
    private static final String ENCODED = "encoded.txt";
    private static final String OUTPUT = "output.txt";
    private static final String DICTIONARY = "dictionary.txt";

    public static final String INPUT_FILE = DIRECTORY + SLASH + INPUT;
    public static final String ENCODED_FILE = DIRECTORY + SLASH + ENCODED;
    public static final String OUTPUT_FILE = DIRECTORY + SLASH + OUTPUT;
    public static final String DICTIONARY_FILE = DIRECTORY + SLASH + DICTIONARY;

    // -- Параметры команд по умолчанию --
    public static final String[] DEFAULT_PARAMETERS_ENCODE = {FunctionCode.ENCODE.toString(), INPUT_FILE, ENCODED_FILE};
    public static final String[] DEFAULT_PARAMETERS_DECODE = {FunctionCode.DECODE.toString(), ENCODED_FILE, OUTPUT_FILE};
    public static final String[] DEFAULT_PARAMETERS_BRUTEFORCE = {FunctionCode.BRUTEFORCE.toString(), ENCODED_FILE, OUTPUT_FILE};
    public static final String[] DEFAULT_PARAMETERS_STAT_ANALYSIS = {FunctionCode.STAT_ANALYSIS.toString(), ENCODED_FILE, OUTPUT_FILE};

    // --  --
    public static final String REGEX = "([а-яёА-ЯЁ]+(\\s|,\\s|.\\s|:\\s|\\s-\\s)){3,}";
    public static final String EMPTY = "";
    public static final String INPUT_FILE_NAME = "Входной файл: ";
    public static final String OUTPUT_FILE_NAME = "Выходной файл: ";
    public static final String KEY_NAME = "Ключ: ";


}
