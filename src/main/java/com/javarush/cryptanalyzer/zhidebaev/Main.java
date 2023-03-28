package com.javarush.cryptanalyzer.zhidebaev;

import com.javarush.cryptanalyzer.zhidebaev.view.GUI;

import static com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet.ALPHABET;

public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI();
        System.out.println(ALPHABET.length());
    }
}