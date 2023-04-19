package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Decode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Encode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;


import java.io.FileReader;
import java.io.FileWriter;

public class Decoder implements Function{
    private String  encodedFile = FileConstants.ENCODED_FILE,
                    outputFile = FileConstants.OUTPUT_FILE;
    private int key;
    private char[] encodedTextSymbols;
    private Decode decoderChars = new Decode();
    private StringBuilder decodedText = new StringBuilder();

    @Override
    public Result execute(String[] commandParameters) {

        System.out.println("works Decoder");
        try {
            encodedFile = commandParameters[0];   // -- Получение пути к файлу для чтения символов --
            outputFile = commandParameters[1]; // -- Получение пути к файлу для записи символов --
            key = Integer.parseInt(commandParameters[2]); // -- Получение и преобразование ключа в целое число --

            // -- Чтение текста из указного файла в виде массива символов --
            encodedTextSymbols = new ReadingFromFile(encodedFile).getFileAsArrayOfCharacters();

            // -- Перебор каждого символа в массиве с авто дешифрованием и преобразованием в текст --
            for(int i = 0; i < encodedTextSymbols.length; i++) {
                decodedText.append(decoderChars.decodeChar(encodedTextSymbols[i], key));
            }
            // -- Запись дешифрованного текста в файл назначения --
            new WritingToFile(outputFile,decodedText.toString());
        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Decoder error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
