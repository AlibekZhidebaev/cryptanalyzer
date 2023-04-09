package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;

import java.io.FileReader;
import java.io.FileWriter;

public class Decoder implements Function{

    String sourceFile = "text//encoded.txt";
    String destinationFile = "text//output.txt";
    int key =3;

    public char encode(int key, char symbol) {
        int offsetNumber = -key;
        char changedCharacter = symbol;
        if (CryptoAlphabet.ALPHABET.lastIndexOf(symbol) != -1) {
            int positionIndex = CryptoAlphabet.ALPHABET.lastIndexOf(symbol) + offsetNumber;
            if (positionIndex > (CryptoAlphabet.ALPHABET_SIZE - 1)) {
                positionIndex = positionIndex - CryptoAlphabet.ALPHABET_SIZE;
            }
            if (positionIndex < 0) {
                positionIndex = positionIndex + CryptoAlphabet.ALPHABET_SIZE;
            }
            changedCharacter = CryptoAlphabet.ALPHABET.charAt(positionIndex);
        }
        return changedCharacter;
    }

    @Override
    public Result execute() {
        try (FileReader reader = new FileReader(sourceFile); FileWriter writer = new FileWriter(destinationFile)) {
            System.out.println("works Decode");
            while (reader.ready()) {
                char real = (char) reader.read();
                writer.write(encode(key, real));
            }
        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Decode error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
