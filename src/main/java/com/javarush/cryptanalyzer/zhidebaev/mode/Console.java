package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// -- Класс-оболочка консольного режима --
public class Console {
    private int choiceNumber ;
    private List<String> parameters;
    private String command;
    private ConsoleView consoleview;
    private boolean launch = true;

    public Console(){
        System.out.println("Select operation number:\n"
                + "1.ENCODE\n"
                + "2.DECODE\n"
                + "3.Brute force\n"
                + "4.Statistical analysis\n"
        );

        try (Scanner scan = new Scanner(System.in)) {
            while (launch) {
                choiceNumber = scan.nextInt();

                switch (choiceNumber) {
                    case 1:
                        parameters = getParametrsForEncoder();
                        break;
                    case 2:
                        parameters = getParametrsForDecoder();
                        break;
                    case 3:
                        parameters = getParametrsForBruteForcer();
                        break;
                    case 4:
                        parameters = getParametrsForStatAnalysis();
                        break;
                    case 5:
                        parameters = getParametrsForNonExistingClass();
                        break;
                    default:
                        launch = false;
                        System.out.println("Application complete! Goodbye, see you again.");
                        break;

                }
                // -- Передача выбранной команды в виде параметра в экземпляр класса ConsoleView --
                consoleview = new ConsoleView(parameters);
                // -- Передача экземпляра класса ConsoleView в виде параметра в исполняющий класс Run (Запуск) --
                new Run(consoleview);
            }
        }
    }

    //------------------------Метод для получения параметров Encoder'a---------------------------------------------

    private List<String> getParametrsForEncoder() {
        List<String> parametrsForEncoder = new ArrayList<>();
        parametrsForEncoder.add("ENCODE");
        parametrsForEncoder.add(FileConstants.INPUT_FILE);
        parametrsForEncoder.add(FileConstants.ENCODED_FILE);
        parametrsForEncoder.add("3");
        return parametrsForEncoder;
    }

//------------------------Метод для получения параметров Decoder'a---------------------------------------------

    private List<String> getParametrsForDecoder() {
        List<String> parametrsForDecoder = new ArrayList<>();
        parametrsForDecoder.add("DECODE");
        parametrsForDecoder.add(FileConstants.ENCODED_FILE);
        parametrsForDecoder.add(FileConstants.OUTPUT_FILE);
        parametrsForDecoder.add("3");
        return parametrsForDecoder;
    }

//------------------------Метод для получения параметров BruteForcer'a---------------------------------------------

    private List<String> getParametrsForBruteForcer() {
        List<String> parametrsForBruteForcer = new ArrayList<>();
        parametrsForBruteForcer.add("BRUTEFORCE");
        parametrsForBruteForcer.add(FileConstants.ENCODED_FILE);
        parametrsForBruteForcer.add(FileConstants.OUTPUT_FILE);
        parametrsForBruteForcer.add("3");
        return parametrsForBruteForcer;
    }

//------------------------Метод для получения параметров StatAnalysis'a---------------------------------------------

    private List<String> getParametrsForStatAnalysis() {
        List<String> parametrsForStatAnalysis = new ArrayList<>();
        parametrsForStatAnalysis.add("STAT_ANALYSIS");
        parametrsForStatAnalysis.add(FileConstants.ENCODED_FILE);
        parametrsForStatAnalysis.add(FileConstants.OUTPUT_FILE);
        parametrsForStatAnalysis.add("3");
        return parametrsForStatAnalysis;
    }

//------------------------Метод для получения параметров NonExistingClass'a---------------------------------------------

    private List<String> getParametrsForNonExistingClass() {
        List<String> ParametrsForNonExistingClass = new ArrayList<>();
        ParametrsForNonExistingClass.add("NONEXISTCLASS");
        ParametrsForNonExistingClass.add(FileConstants.EMPTY);
        ParametrsForNonExistingClass.add(FileConstants.EMPTY);
        ParametrsForNonExistingClass.add(FileConstants.EMPTY);

        return ParametrsForNonExistingClass;
    }

}

