package com.javarush.cryptanalyzer.zhidebaev.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View{
    private List <String> parameters;

    public ConsoleView(List<String> parameters) {
        this.parameters = parameters;
    }
    // -- Метод получающий список параметров с экземпляра класса-оболочки Console --
    @Override
    public String[] getParameters() {
        String[] param = parameters.toArray(new String[0]);
        return param;
    }
}
