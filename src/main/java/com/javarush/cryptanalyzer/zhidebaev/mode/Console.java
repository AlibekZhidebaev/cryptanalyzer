package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;

import java.util.Scanner;

public class Console {
    private int choiceNumber ;
    private String command;
    private ConsoleView consoleview;

    public Console(){
        System.out.println("Select operation:\n"
                + "1.ENCODE\n"
                + "2.DECODE\n"
                + "3.Brute force\n"
                + "4.Statistical analysis\n"
        );

        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                choiceNumber = scan.nextInt();
                switch (choiceNumber) {
                    case 1:
                        command = "ENCODE";
                        break;
                    case 2:
                        command = "DECODE";
                        break;
                    case 3:
                        command = "BRUTEFORCE";
                        break;
                    case 4:
                        command = "STAT_ANALYSIS";
                        break;
                    default:
                        command = "NONEXISTCLASS";
                        break;
                }
                consoleview = new ConsoleView(command);
                new Run(consoleview);
            }
        }
    }
}
