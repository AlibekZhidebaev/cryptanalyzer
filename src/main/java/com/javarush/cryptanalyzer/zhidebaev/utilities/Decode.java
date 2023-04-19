package com.javarush.cryptanalyzer.zhidebaev.utilities;

public class Decode {

    // -- Метод декодирования символа с помощью ключа по методу Цезаря --
    public char decodeChar(char symbol, int key) {
        // -- преобразование ключа с положительного на отрицательное число --
        int negativeKey = -key;
        // -- Декодирование символа (кодирование с отрицательным ключом)  с помощью метода экземпляра класса Encode--
        char output = new Encode().encodeChar(symbol, negativeKey);
        return output;
    }

    // -- Метод декодирования строки с помощью ключа по методу Цезаря --
    public String decodeString(String text, int key) {
        int negativeKey = -key;
        String output = new Encode().encodeString(text, negativeKey);
        return output;
    }

}

