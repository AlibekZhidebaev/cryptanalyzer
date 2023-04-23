package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;

public class Encode {
    private  static final String Alphabet = CryptoAlphabet.ALPHABET;
    private  static final int AlphabetSize = CryptoAlphabet.ALPHABET_SIZE;

    // -- Метод кодирования символа с помощью ключа по методу Цезаря --
    public static char encodeChar(char symbol, int key) {

        char changedCharacter = symbol;
        // -- преобразование ключа в позицию сдвига относительно символа --
        int movePosition = (key + AlphabetSize) % AlphabetSize;

        // -- Игнорирование символов отсутствующих в указанном криптоалфавите --
        if (Alphabet.lastIndexOf(symbol) != -1) {
            // -- Сдвиг относительно символа --
            int positionIndex = Alphabet.lastIndexOf(symbol) + movePosition;
            // -- Преобразования полученного индекса позиции в результате сдвига, если выходит за пределы криптоалфавита --
            if (positionIndex > (AlphabetSize - 1)) { positionIndex = positionIndex - AlphabetSize; }
            // -- Получение символа в криптоалфавите по указанному индексу после сдвига -
            changedCharacter = Alphabet.charAt(positionIndex);
        }
        return changedCharacter;
    }

    // -- Метод шифрования строк текста по методу Цезаря --
    public static String encodeString (String text, int key) {

        String outputText = "";
        int positionIndex;
        StringBuilder output = new StringBuilder(outputText);

        // -- преобразование ключа в позицию сдвига относительно символа --
        int movePosition = (key + AlphabetSize) % AlphabetSize;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);               // -- Получение символа из массива строки по указанному индексу --
            if (Alphabet.lastIndexOf(symbol) != -1) {   // -- Игнорирование символов отсутсвующих в указанном криптоалфавите --
                positionIndex = Alphabet.lastIndexOf(symbol) + movePosition;	// -- Сдвиг относительно символа --
                // -- Преобразование полученного индекса позиции в результате сдвига, если выходит за пределы криптоалфавита --
                if (positionIndex > (AlphabetSize - 1)) {positionIndex = positionIndex - AlphabetSize;}
                if (positionIndex < 0) { positionIndex = positionIndex + AlphabetSize;}
                // -- Получение символа в криптоалфавите по указанному индексу после сдвига --
                symbol = Alphabet.charAt(positionIndex);
            }
            output.append(symbol); // -- Добавление символа в новую строку --
            outputText = output.toString();
        }
        return outputText;
    }


}
