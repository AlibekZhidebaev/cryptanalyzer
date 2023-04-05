package com.javarush.cryptanalyzer.zhidebaev.repository;

import com.javarush.cryptanalyzer.zhidebaev.services.*;

public enum FunctionCode {

    ENCODE (new Encoder()),
    DECODE (new Decoder());

    private final Function function;

    FunctionCode(Function function){
        this.function = function;
    }
    private Function getFunction() {
        return function;
    }
    public static Function find(String mode) {
        Function function = FunctionCode.valueOf(mode.toUpperCase()).getFunction();
        return function;
    }
}
