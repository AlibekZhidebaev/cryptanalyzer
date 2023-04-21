package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Encode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;

public class Encoder implements Function{
    private String  inputFile = FileConstants.INPUT_FILE,
                    encodedFile = FileConstants.ENCODED_FILE;
    private int key;
    private char[] sourceTextSymbols;
    private Encode encoderChars = new Encode();
    private StringBuilder encodedText = new StringBuilder();
    @Override
    public Result execute(String[] commandParameters) {
            System.out.println("----------------------");
            System.out.println("    works Encoder");
            System.out.println("------- Result -------");
        try {
            inputFile = commandParameters[0];   // -- Получение пути к файлу для чтения символов --
            encodedFile = commandParameters[1]; // -- Получение пути к файлу для записи символов --
            key = Integer.parseInt(commandParameters[2]); // -- Получение и преобразование ключа в целое число --

            // -- Чтение текста из указного файла в виде массива символов --
            sourceTextSymbols = new ReadingFromFile(inputFile).getFileAsArrayOfCharacters();

                // -- Перебор каждого символа в массиве с авто шифрованием и преобразованием в текст --
                for(int i = 0; i < sourceTextSymbols.length; i++) {
                encodedText.append(encoderChars.encodeChar(sourceTextSymbols[i], key));
                 }
            // -- Запись зашифрованного текста в файл назначения --
            new WritingToFile(encodedFile,encodedText.toString());

        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException(ex.getMessage(), ex));
        }
        return new Result(ResultCode.OK);
    }
}
