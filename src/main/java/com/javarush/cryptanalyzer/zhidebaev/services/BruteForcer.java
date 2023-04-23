package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Decode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.PatternChecking;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;

public class BruteForcer implements Function {

    @Override
    public Result execute(String[] commandParameters){
            System.out.println("----------------------");
            System.out.println("  works BruteForcer");
            System.out.println("------- Result -------");
        try {
            String encodedFile = commandParameters[0]; // -- Получение пути к файлу для чтения символов --
            String outputFile = commandParameters[1];  // -- Получение пути к файлу для записи символов --

            // -- Чтение текста из указного файла в виде строки текста --
            String encodedText = new ReadingFromFile(encodedFile).getFileAsString();

            // -- Дешифруем текст с перебором ключа --
            for (int key = 1; key < CryptoAlphabet.ALPHABET_SIZE; key++) {
                // -- Дешифруем текст с перебором ключа --
                String decodedText = Decode.decodeString(encodedText, key);
                // -- Проверка дешифрованного текста на соответствие регулярному выражению --
                 if (PatternChecking.getPatternIsValid(decodedText)) {
                // -- Если соответствие подвержено, записываем текст в файл назначения --
                     new WritingToFile(outputFile, decodedText);
                System.out.println("Correct key: = " + key);
                break;
                }
            }
        } catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("BruteForcer error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
