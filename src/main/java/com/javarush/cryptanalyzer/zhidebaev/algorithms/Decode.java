package com.javarush.cryptanalyzer.zhidebaev.algorithms;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet.ALPHABET_SIZE;

public class Decode {
    String src = "files//output.txt";
    String dest = "files//decoded.txt";
    // char changedCharacter;
    public Decode() throws IOException {
        try (
                FileReader reader = new FileReader(src);
                FileWriter writer = new FileWriter(dest))
        {
            // char[] buffer = new char[65536]; // 64Kb
            while (reader.ready())
            {
                //int real = reader.read(buffer);
                char real = (char) reader.read();
                //changedCharacter = encode(3,real);
                writer.write(encode(3,real));
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
    public char encode(int key,char symbol){
        int offsetNumber = -key;
        char changedCharacter = symbol;
        if(ALPHABET.lastIndexOf(symbol)!=-1) {
            int positionIndex = ALPHABET.lastIndexOf(symbol) + offsetNumber;
            if (positionIndex > (ALPHABET_SIZE - 1)) {
                positionIndex = positionIndex - ALPHABET_SIZE;
            }
            if (positionIndex < 0) {
                positionIndex = positionIndex + ALPHABET_SIZE;
            }
            changedCharacter = ALPHABET.charAt(positionIndex);
        }
        return changedCharacter;
    }
}
