package com.javarush.cryptanalyzer.zhidebaev.view;

import java.util.Scanner;

public class ConsoleView implements View{
    private int choiceNumber ;
    private String choice;

    public ConsoleView(){

        System.out.println("Select operation:\n"
                + "1.ENCODE\n"
                + "2.DECODE\n"
                + "3.Brute force\n"
                + "4.Statistical analysis\n"
        );

        try (Scanner scan = new Scanner(System.in)) {

            choiceNumber = scan.nextInt();

            switch(choiceNumber) {
                case 1: choice = "ENCODE"; break;
                case 2: choice = "DECODE"; break;
                case 3: choice = "BRUTEFORCE"; break;
                case 4: choice = "STAT_ANALYSIS"; break;
                default: choice = "NONEXISTCLASS"; break;
            }
        }
    }
    @Override
    public String[] getParametrs() {
        String[] param = {choice};
        return param;
        //return new String[0];
    }
}
