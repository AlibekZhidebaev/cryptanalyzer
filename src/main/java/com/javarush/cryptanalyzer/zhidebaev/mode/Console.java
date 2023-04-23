package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.repository.FunctionCode;
import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Validate;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// -- Класс-оболочка консольного режима --
public class Console {
    private List<String> parameters;

    public Console() {

        // -- Поле выбора команд --
        System.out.println("""
                COMMANDS:
                1.ENCODE
                2.DECODE
                3.Brute force
                4.Statistical analysis
                5.EXIT"""
        );
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("----------------------");
                System.out.println("| 1:ENCODE | 2:DECODE | 3:Brute force | 4:Statistical analysis | 5:EXIT |");
                System.out.println("Select COMMAND number:");
                // -- Проверка корректности ввода --
                int selectNumber = Validate.inputValidation(scan, 1, 5);
                // -- Поле выбора команд --
                switch (selectNumber) {
                    case 1 -> parameters = getParameters(scan, FileConstants.DEFAULT_PARAMETERS_ENCODE);
                    case 2 -> parameters = getParameters(scan, FileConstants.DEFAULT_PARAMETERS_DECODE);
                    case 3 -> parameters = getParameters(scan, FileConstants.DEFAULT_PARAMETERS_BRUTEFORCE);
                    case 4 -> parameters = getParameters(scan, FileConstants.DEFAULT_PARAMETERS_STAT_ANALYSIS);
                    case 5 -> {
                        System.out.println("Application complete! Goodbye, see you again.");
                        System.exit(0);
                    }
                }
                // -- Передача выбранной команды в виде параметра в экземпляр класса ConsoleView --
                ConsoleView consoleview = new ConsoleView(parameters);
                // -- Передача экземпляра класса ConsoleView в виде параметра в исполняющий класс Run (Запуск) --
                new Run(consoleview);
            }
        }
    }

    // -- Метод для получения параметров --
    private List<String> getParameters(Scanner scan, String[] defaultParameters) {
        List<String> parameters = new ArrayList<>(List.of(defaultParameters));
        if (parameters.get(0).equals("ENCODE") || parameters.get(0).equals("DECODE")) {
            System.out.println("Enter the ENCRYPTION KEY");
            parameters.add(String.valueOf(Validate.inputValidation(scan, 1, CryptoAlphabet.ALPHABET_SIZE)));
        }
        changeParameters(parameters);
        return parameters;
    }

    // -- Метод для мзменения параметров в списке --
    private void changeParameters(List<String> parameters) {
        Scanner scan = new Scanner(System.in);
        // -- Информация о параметрах команды --
        System.out.printf("| command: %s | input file: %s | output file: %s | \n",
                parameters.get(0), parameters.get(1), parameters.get(2));
        // -- Сообщение об измененении --
        System.out.print("Want to change the input and output file? [type \"y\" or press Enter] ");
        // -- Если утвердительный ответ, то изменяем параметры --
        if (scan.nextLine().equalsIgnoreCase("y")) {
            String inputFile = changeParameter(scan, FileConstants.INPUT_FILE_NAME);
            String outputFile = changeParameter(scan, FileConstants.OUTPUT_FILE_NAME);
            // -- Изменение параметров в списке --
            parameters.set(1, inputFile);
            parameters.set(2, outputFile);
        } else System.out.println("Done.");
        // -- Информация о параметрах команды после изменения --
        System.out.printf("| command: %s | input file: %s | output file: %s | \n",
                parameters.get(0), parameters.get(1), parameters.get(2));
    }

    // -- Метод изменения значения параметра --
    private String changeParameter(Scanner scan, String message) {
        String pathFile = "";
        // -- Если пустая строка, то зациклить пока не введут данные --
        while (pathFile.isEmpty()) {
            System.out.print(message);
            pathFile = scan.nextLine();
        }
        return pathFile;
    }
}

