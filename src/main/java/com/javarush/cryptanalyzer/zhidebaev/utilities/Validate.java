package com.javarush.cryptanalyzer.zhidebaev.utilities;

import java.util.Scanner;

public class Validate {
    // -- Метод проверки корректности ввода c параметром сканера --
    public static int inputValidation(Scanner scan, int minNumber, int maxNumber){
        int number;
        do {
            System.out.print("Enter a number from "+ minNumber + " to " + maxNumber +": ");
            while (!scan.hasNextInt()) { // -- Если введенные данные не числа --
                System.out.println("You didn't enter a number. Try again.");
                scan.next();
            }
            number = scan.nextInt();
        } while (number < minNumber || number > maxNumber); // -- Если введенные числа не от 1го до 5ти --
        return number;
    }
}
