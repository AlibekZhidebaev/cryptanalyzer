package com.javarush.cryptanalyzer.zhidebaev.controller;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.services.Function;
import com.javarush.cryptanalyzer.zhidebaev.view.View;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;

@SuppressWarnings("ALL")
public class MainController {
    private final View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    // -- Метод для выполнения (execute()) действия с заданными параметрами --
    public Result execute(String command, String[] commandParameters) {
        // -- Передаем параметр command в метод find() (найти) класса-списка FunctionCode и выполняем его --
        Function function = FunctionCode.find(command);
        // -- В метод execute() (выполнить),найденной команды, передаем параметр commandParameters и выполняем --
        return function.execute(commandParameters);
    }
}
