package com.javarush.cryptanalyzer.zhidebaev.view;

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
        String[] param = { parameters.get(0),parameters.get(1),parameters.get(2),parameters.get(3) };
        return param;
    }
}
