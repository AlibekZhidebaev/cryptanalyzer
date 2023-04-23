package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.utilities.Validate;

import java.util.Scanner;

public class Mode {

    public Mode() {
        // -- Поле выбора режима --
        System.out.println("""
                Jobs MODE:
                1.Console View
                2.GUI View
                """);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Select MODE");
            // -- Проверка корректности ввода --
            int selectNumber = Validate.inputValidation(scan, 1, 2);
            // -- Переключатель режима --
            switch (selectNumber) {
                case 1 -> new Console(); // -- Запуск приложения в консольном режиме --
                case 2 -> new GUI();     // -- Запуск приложения в графическом режиме --
            }
        }
    }
}

