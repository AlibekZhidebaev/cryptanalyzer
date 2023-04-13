package com.javarush.cryptanalyzer.zhidebaev.constants;

public final class  CryptoAlphabet {
    private static final String lettersUpperCase ="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String lettersLowerCase ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String NUMBERS ="0123456789";
    private static final String SYMBOLS =".,\":-!? ";
    public static final String ALPHABET = lettersUpperCase+lettersLowerCase+NUMBERS+SYMBOLS;
    public static final int ALPHABET_SIZE = ALPHABET.length();
}
