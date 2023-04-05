package com.javarush.cryptanalyzer.zhidebaev.controller;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.services.Function;
import com.javarush.cryptanalyzer.zhidebaev.view.View;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;

public class MainController {
    private View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public Result excecute (String mode) {
        Function function = FunctionCode.find(mode);
        Result result = function.execute();
        return result;
    }
}
