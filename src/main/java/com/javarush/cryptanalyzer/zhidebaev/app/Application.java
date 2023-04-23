package com.javarush.cryptanalyzer.zhidebaev.app;

import com.javarush.cryptanalyzer.zhidebaev.controller.MainController;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;

import java.util.Arrays;

public class Application {
    private final MainController maincontroller;

    public Application(MainController maincontroller) {
        this.maincontroller = maincontroller;
    }

    // -- Метод для выполнения (run()) действия приложения (Application) --
    public Result run() {
        // -- С помощью контроллера maincontroller получаем параметры с интерфейса View в виде массива строк --
        String[] parameters = maincontroller.getView().getParameters();
        // -- 1-й элемент массива назначаем как команду --
        String command = parameters[0];
        // -- Остальные элементы назначаем,как параметры назначенной команды --
        String[] commandParameters = Arrays.copyOfRange(parameters, 1, parameters.length);
        // -- Передаем команду с параметрами в метод execute (выполнить) контроллера maincontroller и запускаем его --
        return maincontroller.execute(command, commandParameters);
    }
}
