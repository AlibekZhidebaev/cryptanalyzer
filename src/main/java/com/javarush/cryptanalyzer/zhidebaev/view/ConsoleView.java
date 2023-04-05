package com.javarush.cryptanalyzer.zhidebaev.view;

import java.util.Scanner;

public class ConsoleView implements View{
    private int choiceNumber;
    private String choice;

    public ConsoleView(){


        System.out.println("Select operation: "
                + "\n 1.ENCODE"
                + "\n 2.DECODE");

        Scanner scan = new Scanner(System.in);
        choiceNumber = scan.nextInt();
        switch(choiceNumber) {
            case 1: choice = "ENCODE";break;
            case 2: choice = "DECODE";break;
            // default: choice = "ENCODE";
        }
        scan.close();

    }
    @Override
    public String[] getParametrs() {
        String[] param = {choice};
        return param;
        //return new String[0];
    }
}
