package com.javarush.cryptanalyzer.zhidebaev.mode;

import java.util.Scanner;

public class Mode {
    private int selectNumber;

    public Mode() {

        System.out.println("Select mode:\n" +
                "1.Console View\n" +
                "2.GUI View\n");

        try (Scanner scan = new Scanner(System.in)) {
            selectNumber = scan.nextInt();
            switch (selectNumber) {
                case 1:
                    new Console();
                    break;
                case 2:
                    new GUI();
                    break;
            }
        }
    }
}
