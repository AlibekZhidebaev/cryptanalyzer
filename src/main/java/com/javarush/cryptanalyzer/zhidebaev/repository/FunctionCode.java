package com.javarush.cryptanalyzer.zhidebaev.repository;

import com.javarush.cryptanalyzer.zhidebaev.services.*;

public enum FunctionCode {
    ENCODE (new Encoder()), // -- команда запускающий Кодировщик (класс Encoder()) --
    DECODE (new Decoder()), // -- команда запускающий Декодер (класс Decoder()) --
    BRUTEFORCE (new BruteForcer()), // -- команда запускающий Брут форс (класс BruteForcer()) --
    STAT_ANALYSIS (new StatAnalysis()); // -- команда запускающий статистический анализатор (класс StatAnalysis()) --

    private final Function function;
    FunctionCode(Function function){
        this.function = function;
    }
    private Function getFunction() {
        return function;
    }

    // -- метод find() (найти) для поиска команды в текущем списке --
    public static Function find(String command) {
        // -- Преобразование данных и получение соответствующей команды с помощью метода getFunction() --
        Function function = FunctionCode.valueOf(command.toUpperCase()).getFunction();
        return function;
    }
}
