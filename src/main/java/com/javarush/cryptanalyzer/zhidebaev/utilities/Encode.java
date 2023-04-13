package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;

public class Encode {
    private final String Alphabet = CryptoAlphabet.ALPHABET;
    private final int AlphabetSize = CryptoAlphabet.ALPHABET_SIZE;

    // -- Метод кодирования символа с помощью ключа по методу Цезаря --
    public char encode(char symbol, int key) {

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
}
