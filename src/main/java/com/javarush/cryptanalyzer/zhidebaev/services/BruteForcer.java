package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForcer implements Function {
    String  encodedFile = FileConstants.ENCODED_FILE,
            outputFile = FileConstants.OUTPUT_FILE;
    private int correctKey;
    private String encodedText, decodedText;
    private final Decode decoderText = new Decode();
    private PatternChecking patternChecking = new PatternChecking();


    @Override
    public Result execute(String[] commandParameters){
        try {
            System.out.println("works BruteForcer");
            encodedFile = commandParameters[0]; // -- Получение пути к файлу для чтения символов --
            outputFile = commandParameters[1];  // -- Получение пути к файлу для записи символов --

            // -- Чтение текста из указного файла в виде строки текста --
            encodedText = new ReadingFromFile(encodedFile).getFileAsString();

            // -- Дешифруем текст с перебором ключа --
            for (int key = 1; key < CryptoAlphabet.ALPHABET_SIZE; key++) {
                // -- Дешифруем текст с перебором ключа --
                decodedText = decoderText.decodeString(encodedText, key);
                // -- Проверка дешифрованного текста на соответствие регулярному выражению --
                 if (patternChecking.getPatternIsValid(decodedText) == true) {
                // -- Если соответствие подвержено, записываем текст в файл назначения --
                correctKey = key; new WritingToFile(outputFile,decodedText);
                System.out.println("Correct key: = " + correctKey);
                break;
                }
            }
        } catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("BruteForcer error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
