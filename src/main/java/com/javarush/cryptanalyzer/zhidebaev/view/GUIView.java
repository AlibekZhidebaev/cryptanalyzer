package com.javarush.cryptanalyzer.zhidebaev.view;

public class GUIView implements View {
    private String command;

    public GUIView (String command) {
        this.command = command;
    }

    @Override
    public String[] getParametrs() {
        String[] param = { command };
        return param;
    }
}