package com.javarush.cryptanalyzer.zhidebaev.utilities;

import java.util.Scanner;

public class Validate {
    private static int number;
    // -- Метод проверки корректности ввода c параметром сканера --
    public static int inputValidation(Scanner scan, int minNumber, int maxNumber){
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

    // -- Метод проверки корректности ввода без параметра сканера --
//    public static int inputValidation(int minNumber, int maxNumber){
//       Scanner scan = new Scanner(System.in) ;
//            do {
//                System.out.print("Enter a number from " + minNumber + " to " + maxNumber + ": ");
//                while (!scan.hasNextInt()) { // -- Если введенные данные не числа --
//                    System.out.println("You didn't enter a number. Try again.");
//                    scan.next();
//                }
//                number = scan.nextInt();
//            } while (number < minNumber || number > maxNumber); // -- Если введенные числа не от 1го до 5ти --
//        scan.close();
//        return number;
//    }
}
