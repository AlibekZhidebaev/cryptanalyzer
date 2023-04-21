package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Validate;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Mode {

    public Mode() {
        // -- Поле выбора режима --
        System.out.println("Jobs MODE:\n" +
                "1.Console View\n" +
                "2.GUI View\n");
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Select MODE");
            // -- Проверка корректности ввода --
            int selectNumber = Validate.inputValidation(scan, 1,2);
            // -- Переключатель режима --
            switch (selectNumber) {
                case 1:
                    new Console(); // -- Запуск приложения в консольном режиме --
                    break;
                case 2:
                    new GUI();     // -- Запуск приложения в графическом режиме --
                    break;
            }
        }
    }
}

