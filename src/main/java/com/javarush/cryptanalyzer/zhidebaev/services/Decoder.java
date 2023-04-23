package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Decode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;

public class Decoder implements Function{
    private final StringBuilder decodedText = new StringBuilder();

    @Override
    public Result execute(String[] commandParameters) {
        System.out.println("----------------------");
        System.out.println("    works Decoder");
        System.out.println("------- Result -------");
        try {
            String encodedFile = commandParameters[0];   // -- Получение пути к файлу для чтения символов --
            String outputFile = commandParameters[1]; // -- Получение пути к файлу для записи символов --
            int key = Integer.parseInt(commandParameters[2]); // -- Получение и преобразование ключа в целое число --

            // -- Чтение текста из указного файла в виде массива символов --
            char[] encodedTextSymbols = new ReadingFromFile(encodedFile).getFileAsArrayOfCharacters();

            // -- Перебор каждого символа в массиве с авто дешифрованием и преобразованием в текст --
            for (char encodedTextSymbol : encodedTextSymbols) {
                decodedText.append(Decode.decodeChar(encodedTextSymbol, key));
            }
            // -- Запись дешифрованного текста в файл назначения --
            new WritingToFile(outputFile,decodedText.toString());
        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Decoder error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
