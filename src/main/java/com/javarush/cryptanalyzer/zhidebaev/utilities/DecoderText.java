package com.javarush.cryptanalyzer.zhidebaev.utilities;

public class DecoderText {
    public String decode(String text, int key) {
        int negativeKey = -key;
        String output = new EncodeText().encode(text, negativeKey);
        return output;
    }
}
