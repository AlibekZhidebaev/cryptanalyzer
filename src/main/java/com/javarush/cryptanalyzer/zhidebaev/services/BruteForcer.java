package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Decode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.DecoderText;
import com.javarush.cryptanalyzer.zhidebaev.utilities.PatternChecking;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForcer implements Function {
    Path pathEncodedFile, pathOutputFile;
    private DecoderText decodertext = new DecoderText();
    private PatternChecking patternchekking = new PatternChecking();
    private int correctKey;
    private String regex = "([а-яёА-ЯЁ]+(\\s|,\\s|.\\s|:\\s|\\s-\\s)){3,}";

    @Override
    public Result execute(String[] commandParameters){
        try {
            System.out.println("works BruteForcer");
            pathEncodedFile = Path.of(commandParameters[0]);
            pathOutputFile = Path.of(commandParameters[1]);
            correctKey = Integer.parseInt(commandParameters[2]);
            String encodedText = Files.readString(pathEncodedFile);
            for (int key = 1; key < CryptoAlphabet.ALPHABET_SIZE; key++) {
                String decodedText = decodertext.decode(encodedText, key);
                if (patternchekking.getPatternIsValid(decodedText) == true) {
                    correctKey = key; Files.writeString(pathOutputFile, decodedText);
                    System.out.println("Correct key: = " + correctKey);
                    break;
                }

            }

        } catch (IOException e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Error read/write file", e));
        }catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("BruteForcer error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
