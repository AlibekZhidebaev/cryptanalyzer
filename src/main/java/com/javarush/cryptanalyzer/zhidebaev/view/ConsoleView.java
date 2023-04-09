package com.javarush.cryptanalyzer.zhidebaev.view;


public class ConsoleView implements View{
    private String command;

    public ConsoleView(String command) {
        this.command = command;
    }

    @Override
    public String[] getParametrs() {
        String[] param = { command };
        return param;
    }
}
