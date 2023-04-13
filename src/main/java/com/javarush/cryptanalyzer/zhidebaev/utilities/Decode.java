package com.javarush.cryptanalyzer.zhidebaev.utilities;

public class Decode {
    // -- Метод декодирования символа с помощью ключа по методу Цезаря --
    public char decode(char symbol, int key) {
        // -- преобразование ключа с положительного на отрицательное число --
        int negativeKey = -key;
        // -- Декодирование символа (кодирование с отрицательным ключом)  с помощью метода экземпляра класса Encode--
        char output = new Encode().encode(symbol, negativeKey);
        return output;
    }
}

