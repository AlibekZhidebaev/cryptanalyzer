package com.javarush.cryptanalyzer.zhidebaev.utilities;

import java.util.*;

public class TotalStatisticsOfSymbols {
    private final List<Character> symbols = new ArrayList<>(); // -- список ключей Map --

    public TotalStatisticsOfSymbols(char[] textChars) {
        // -- Создание Map из массива символов (ключ = символ, значение = частотность) --
        Map<Character, Integer> symbolFrequencyMap = new HashMap<>();
        for (char textChar : textChars) {
            int totalNumber = 1;
            if (!Character.isWhitespace(textChar) || textChar == ' ')
                if (symbolFrequencyMap.containsKey(textChar))
                    symbolFrequencyMap.put(textChar, symbolFrequencyMap.get(textChar) + 1);
                else
                    symbolFrequencyMap.put(textChar, totalNumber);
        }

        // -- Сортировка Map по значениям ключей с добавлением ключей и их значений в List --
        Map<Character, Integer> sortedsymbolFrequencyMap =
                new TreeMap<>((e1,e2)->symbolFrequencyMap.get(e2).compareTo(symbolFrequencyMap.get(e1)));
        sortedsymbolFrequencyMap.putAll(symbolFrequencyMap);
        for (HashMap.Entry<Character,Integer> e : sortedsymbolFrequencyMap.entrySet()) {
            Integer value = e.getValue();
            boolean isAdded = false;
            if (!isAdded) {
                // -- список значений ключей Map --
                List<Integer> frequency = new ArrayList<>();
                frequency.add(value);
                symbols.add(e.getKey());
            }
        }
    }
    // -- Метод получения отсортированного списка ключей Map --
    public List<Character> getSymbols() {
        return symbols;
    }
}
