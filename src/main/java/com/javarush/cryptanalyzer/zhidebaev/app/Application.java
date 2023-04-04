package com.javarush.cryptanalyzer.zhidebaev.app;

import com.javarush.cryptanalyzer.zhidebaev.controller.MainConroller;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;
import com.javarush.cryptanalyzer.zhidebaev.services.Function;


public class Application {
    private final MainConroller maincontroller;
    private FunctionCode functioncode;
    public Application(MainConroller maincontroller) {

        this.maincontroller = maincontroller; 
    }

    public Result run() {
       String [] paramters = maincontroller.getView().getParametrs();
       String mode = paramters[0];
       getFunction(mode);
        return null;
    }

    private Function getFunction(String mode) {

        return null;
    }
}
