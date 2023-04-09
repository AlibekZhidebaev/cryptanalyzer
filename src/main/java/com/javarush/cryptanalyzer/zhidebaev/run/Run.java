package com.javarush.cryptanalyzer.zhidebaev.run;

import com.javarush.cryptanalyzer.zhidebaev.app.Application;
import com.javarush.cryptanalyzer.zhidebaev.controller.MainController;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.view.View;

public class Run {

    public Run(View view) {
        MainController maincontroller = new MainController(view);
        Application application = new Application(maincontroller);
        Result result = application.run();
        System.out.println(result);
    }
}
