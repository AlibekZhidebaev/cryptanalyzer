package com.javarush.cryptanalyzer.zhidebaev.utilities;

public class Decode {

    // -- Метод декодирования символа с помощью ключа по методу Цезаря --
    public static char decodeChar(char symbol, int key) {
        // -- преобразование ключа с положительного на отрицательное число --
        int negativeKey = -key;
        // -- Декодирование символа (кодирование с отрицательным ключом)  с помощью метода экземпляра класса Encode--
        return Encode.encodeChar(symbol, negativeKey);
    }

    // -- Метод декодирования строки с помощью ключа по методу Цезаря --
    public static String decodeString(String text, int key) {
        int negativeKey = -key;
        return Encode.encodeString(text, negativeKey);
    }

}

