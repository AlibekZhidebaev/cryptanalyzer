package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Mode {

    public Mode() {
        // -- Поле выбора режима --
        System.out.println("Select mode:\n" +
                "1.Console View\n" +
                "2.GUI View\n");
        Scanner scan = new Scanner(System.in);
        int selectNumber;

        // -- Проверка корректности ввода --
        do {
            System.out.print("Enter a number from 1 or 2: ");
            // -- Если введенные данные не числа --
            while (!scan.hasNextInt()) {
                System.out.println("You didn't enter a number. Try again.");
                scan.next();
            }
            selectNumber = scan.nextInt();
        // -- Если введенные числа не от 1го до 2х --
        } while (selectNumber <= 0 || selectNumber > 2);

        // -- Переключатель режима --
            switch (selectNumber) {
                case 1:
                    new Console(); // -- Запуск приложения в консольном режиме --
                    break;
                case 2:
                    new GUI();     // -- Запуск приложения в графическом режиме --
                    break;
                }
                scan.close();
            }
        }

