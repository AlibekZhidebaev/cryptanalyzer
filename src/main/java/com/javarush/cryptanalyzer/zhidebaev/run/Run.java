package com.javarush.cryptanalyzer.zhidebaev.run;

import com.javarush.cryptanalyzer.zhidebaev.app.Application;
import com.javarush.cryptanalyzer.zhidebaev.controller.MainController;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;
import com.javarush.cryptanalyzer.zhidebaev.view.View;

import javax.swing.*;

// -- Исполняющий класс приложения --
public class Run {

    public Run(View view) {
        MainController maincontroller = new MainController(view);
        Application application = new Application(maincontroller);
        Result result = application.run();
        if (view instanceof ConsoleView) System.out.println(result);
        else JOptionPane.showMessageDialog(null, "Результат: " + result);
    }
}
