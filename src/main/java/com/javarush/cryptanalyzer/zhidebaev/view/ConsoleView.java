package com.javarush.cryptanalyzer.zhidebaev.view;

import java.util.List;

public class ConsoleView implements View {
    private final List<String> parameters;

    public ConsoleView(List<String> parameters) {
        this.parameters = parameters;
    }

    // -- Метод получающий список параметров с экземпляра класса-оболочки Console --
    @Override
    public String[] getParameters() {
        return parameters.toArray(new String[0]);
    }
}
