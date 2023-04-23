package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.TotalStatisticsOfSymbols;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatAnalysis implements Function {
    private final Map<Character,Character > symbolMappings = new HashMap<>();
    private final StringBuilder outputText = new StringBuilder();


    @Override
    public Result execute(String[] commandParameters) {
             System.out.println("----------------------");
             System.out.println(" works StatAnalysis");
             System.out.println("------- Result -------");
        try {
            String inputFile = commandParameters[0];  // -- Получение пути к файлу для чтения символов --
            String outputFile = commandParameters[1]; // -- Получение пути к файлу для записи символов --
            String dictionaryFile = FileConstants.DICTIONARY_FILE;  // -- Получение пути к файлу словаря --
            // -- Чтение текста из файла в виде массива символов --
            char[] sourceTextSymbols = new ReadingFromFile(inputFile).getFileAsArrayOfCharactersToLowerCase();
            char[] dictionarySymbols = new ReadingFromFile(dictionaryFile).getFileAsArrayOfCharactersToLowerCase();
            // -- Получение символов, из указного файла в виде отсортированного по частотности списка --
            List<Character> sourceTextSymbolFrequency = new TotalStatisticsOfSymbols(sourceTextSymbols).getSymbols();
            List<Character> symbolFrequencyDictionary = new TotalStatisticsOfSymbols(dictionarySymbols).getSymbols();
            // -- Выравнивание списков по минимальной длине --
            int mapIndex = Math.min(sourceTextSymbolFrequency.size(), symbolFrequencyDictionary.size());
            // -- Создание, из полученных списков, карты Map для сопоставления символов --
            for(int i=0; i<mapIndex; i++) {
                symbolMappings.put(sourceTextSymbolFrequency.get(i), symbolFrequencyDictionary.get(i));
            }
            // -- Перебор и замена каждого символа в массиве, соответствии карте сопоставления --
            for(int i=0; i<sourceTextSymbols.length; i++) {
                // -- Проверка присутствие символа в карте --
                if(symbolMappings.containsKey(sourceTextSymbols[i]))
                    // -- Если такой символ существует, то по ключу меняем на соответсвующее значение в карте --
                    // -- и каждый символ преобразовываем в строку --
                    outputText.append(sourceTextSymbols[i] = symbolMappings.get(sourceTextSymbols[i]));
                // -- Если символ отсутствует, то оставляем без изменении --
                else outputText.append(sourceTextSymbols[i]);
            }
            // -- Запись текста в файл назначения --
            new WritingToFile(outputFile,outputText.toString());

        } catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException(ex.getMessage(),ex));
        }
        return new Result(ResultCode.OK);
    }
}
