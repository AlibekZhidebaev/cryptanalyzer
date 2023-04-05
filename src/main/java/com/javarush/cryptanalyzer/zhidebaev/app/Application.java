package com.javarush.cryptanalyzer.zhidebaev.app;

import com.javarush.cryptanalyzer.zhidebaev.controller.MainController;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;

public class Application {
    private MainController maincontroller;


    public Application(MainController maincontroller) {
        this.maincontroller = maincontroller;
    }

    public Result run() {
        String[] parametrs = maincontroller.getView().getParametrs();
        String mode = parametrs[0];
        Result result = maincontroller.excecute(mode);
        return result;
    }
}
