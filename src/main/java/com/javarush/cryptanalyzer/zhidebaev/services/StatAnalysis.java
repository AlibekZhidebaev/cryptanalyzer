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
    private String inputFile = "text\\encode.txt";
    private String dictionaryFile = "text\\dictionary.txt";
    private String outputFile = "text\\output.txt";

    List<Character> sourceTextSymbolFrequency = new ArrayList<>();
    List<Character> symbolFrequencyDictionary = new ArrayList<>();
    Map<Character,Character > symbolMappings = new HashMap<>();
    List<Character> outputTextSymbols = new ArrayList<>();
    StringBuilder outputText = new StringBuilder();


    @Override
    public Result execute(String[] commandParameters) {
        try {
            System.out.println("works StatAnalysis");
            // --------------------------------------------------------
            char[] sourceTextSymbols = new ReadingFromFile(inputFile).getFileAsArrayOfCharacters();
            char[] dictionarySymbols = new ReadingFromFile(dictionaryFile).getFileAsArrayOfCharacters();
            sourceTextSymbolFrequency = new TotalStatisticsOfSymbols(sourceTextSymbols).getSymbols();
            symbolFrequencyDictionary = new TotalStatisticsOfSymbols(dictionarySymbols).getSymbols();

            int mapIndex = Math.min(sourceTextSymbolFrequency.size(), symbolFrequencyDictionary.size());
            for(int i=0; i<mapIndex; i++) {
                symbolMappings.put(sourceTextSymbolFrequency.get(i), symbolFrequencyDictionary.get(i));
            }

            for(int i=0; i<sourceTextSymbols.length; i++) {
                if(symbolMappings.containsKey(sourceTextSymbols[i]))
                    outputText.append(sourceTextSymbols[i] = symbolMappings.get(sourceTextSymbols[i]));
                else outputText.append(sourceTextSymbols[i] = sourceTextSymbols[i]);
            }

            new WritingToFile(outputFile,outputText.toString());
            System.out.println(symbolMappings);

            // ---------------------------------------------------------
        } catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException(ex.getMessage(),ex));
        }
        return new Result(ResultCode.OK);
    }
}
