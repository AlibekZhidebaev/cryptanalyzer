package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;

public class EncodeText {
    private final String Alphabet = CryptoAlphabet.ALPHABET;
    private final int AlphabetSize = CryptoAlphabet.ALPHABET_SIZE;


    // -- Метод шифрования строк текста по методу Цезаря --

    public String encode(String text, int key) {

        String outputText = "";
        StringBuilder output = new StringBuilder(outputText);

        int positionIndex = 0;
        int movePosition = (key + AlphabetSize) % AlphabetSize; // -- преобразование ключа в позицию сдвига относительно символа --

        for (int x = 0; x < text.length(); x++) {
            char symbol = text.charAt(x);               // -- Получение символа из массива строки по указанному индексу --
            if (Alphabet.lastIndexOf(symbol) != -1) {   // -- Игнорирование символов отсутсвующих в указанном криптоалфавите --
                positionIndex = Alphabet.lastIndexOf(symbol) + movePosition;	// -- Сдвиг относительно символа --

                // -- Преобразования полученного индекса позиции в результате сдвига, если выходит за пределы криптоалфавита --

                if (positionIndex > (AlphabetSize - 1)) {positionIndex = positionIndex - AlphabetSize;}
                if (positionIndex < 0) { positionIndex = positionIndex + AlphabetSize;}

                symbol = Alphabet.charAt(positionIndex); // -- Получение символа в криптоалфавите по указанному индексу после сдвига --
            }
            output.append(symbol); // -- Добавление символа в новую строку --
            outputText = output.toString();
        }
        return outputText;
    }

}
