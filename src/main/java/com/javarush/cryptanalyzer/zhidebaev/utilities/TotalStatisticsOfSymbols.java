package com.javarush.cryptanalyzer.zhidebaev.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalStatisticsOfSymbols {
    private char[] textChars;
    private Map<Character, Integer> symbolFrequencyMap = new HashMap<Character, Integer>(); // -- Map --
    private List<Character> symbols = new ArrayList<>(); // -- список ключей Map --
    private List<Integer> frequency = new ArrayList<>();   // -- список значений ключей Map --
    private int totalNumber = 1;

    // -- Метод получения списка значений ключей Map --
    public List<Character> getSymbols() {
        return symbols;
    }
    public TotalStatisticsOfSymbols(char[] textChars) {
        this.textChars = textChars;
        // -- Создание Map из массива символов (ключ = символ, значение = частотность) --
        for (int i = 0; i < textChars.length; i++) {
            if(!Character.isWhitespace(textChars[i]) || textChars[i] == ' ')
                if (symbolFrequencyMap.containsKey(textChars[i]))
                    symbolFrequencyMap.put(textChars[i], symbolFrequencyMap.get(textChars[i]) + 1);
                else
                    symbolFrequencyMap.put(textChars[i], totalNumber);
        }

        // -- Сортировка Map по значениям ключей с добавлением ключей и их значений в List --
        for (HashMap.Entry<Character,Integer> e : symbolFrequencyMap.entrySet()) {
            Integer value = e.getValue();
            boolean isAdded = false;
            for (int i = 0; i < frequency.size(); i++) {
                if (value > frequency.get(i)) { // -- условие сортировки значений
                    frequency.add(i, value);
                    symbols.add(i, e.getKey());
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                frequency.add(value);
                symbols.add(e.getKey());
            }
        }
    }
}
