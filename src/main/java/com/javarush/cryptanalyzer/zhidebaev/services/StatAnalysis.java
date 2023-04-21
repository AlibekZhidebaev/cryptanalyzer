package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.ReadingFromFile;
import com.javarush.cryptanalyzer.zhidebaev.utilities.TotalStatisticsOfSymbols;
import com.javarush.cryptanalyzer.zhidebaev.utilities.WritingToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatAnalysis implements Function {
    private String inputFile = "text\\encoded.txt";
    private String dictionaryFile = "text\\dictionary.txt";
    private String outputFile = "text\\output.txt";
    private List<Character> sourceTextSymbolFrequency = new ArrayList<>(),
                            symbolFrequencyDictionary = new ArrayList<>();
    private Map<Character,Character > symbolMappings = new HashMap<>();
    private StringBuilder outputText = new StringBuilder();


    @Override
    public Result execute(String[] commandParameters) {
             System.out.println("----------------------");
             System.out.println(" works StatAnalysis");
             System.out.println("------- Result -------");
        try {
            // -- Чтение текста из файла в виде массива символов --
            char[] sourceTextSymbols = new ReadingFromFile(inputFile).getFileAsArrayOfCharactersToLowerCase();
            char[] dictionarySymbols = new ReadingFromFile(dictionaryFile).getFileAsArrayOfCharactersToLowerCase();

            // -- Получение символов, из указного файла в виде отсортированного по частотности списка --
            sourceTextSymbolFrequency = new TotalStatisticsOfSymbols(sourceTextSymbols).getSymbols();
            symbolFrequencyDictionary = new TotalStatisticsOfSymbols(dictionarySymbols).getSymbols();

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
            System.out.println(symbolMappings);

        } catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException(ex.getMessage(),ex));
        }
        return new Result(ResultCode.OK);
    }
}
