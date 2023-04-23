package com.javarush.cryptanalyzer.zhidebaev.view;

import java.util.List;

public class GUIView implements View {
    private final List<String> parameters;

    public GUIView(List<String> parameters) {
        this.parameters = parameters;
    }

    // -- Метод получающий список параметров с экземпляра класса-оболочки GUI --
    @Override
    public String[] getParameters() {
        return parameters.toArray(new String[0]);
    }
}