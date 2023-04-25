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
        if (view instanceof ConsoleView) {
            System.out.println("-".repeat(30));
            System.out.println(" ".repeat(8) + "works "+ application.getCommand());
            System.out.println("-".repeat(11)+" Result "+"-".repeat(11));
            System.out.println(result);}
        else JOptionPane.showMessageDialog(null, result,"Результат",JOptionPane.INFORMATION_MESSAGE);
    }

}
