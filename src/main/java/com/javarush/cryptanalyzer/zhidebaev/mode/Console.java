package com.javarush.cryptanalyzer.zhidebaev.mode;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.run.Run;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Validate;
import com.javarush.cryptanalyzer.zhidebaev.view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// -- Класс-оболочка консольного режима --
public class Console {
    private ConsoleView consoleview;
    // -- Параметры команд по умолчанию --
    private String[] defaultEncode = {"ENCODE",FileConstants.INPUT_FILE,FileConstants.ENCODED_FILE};
    private String[] defaultDecode = {"DECODE",FileConstants.ENCODED_FILE,FileConstants.OUTPUT_FILE};
    private String[] defaultBruteForce = {"BRUTEFORCE",FileConstants.ENCODED_FILE,FileConstants.OUTPUT_FILE};
    private String[] defaultStatAnalysis = {"STAT_ANALYSIS",FileConstants.ENCODED_FILE,FileConstants.DICTIONARY_FILE};
    private List<String> parameters;

    public Console(){
        // -- Поле выбора команд --
        System.out.println("COMMANDS:\n"
                + "1.ENCODE\n"
                + "2.DECODE\n"
                + "3.Brute force\n"
                + "4.Statistical analysis\n"
                + "5.EXIT"
        );
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("----------------------");
                System.out.println("Select COMMAND number:");
                // -- Проверка корректности ввода --
                int selectNumber = Validate.inputValidation(scan,1,5);
                // -- Поле выбора команд --
                switch (selectNumber) {
                    case 1:
                        parameters = getParameters(scan,defaultEncode);
                        break;
                    case 2:
                        parameters = getParameters(scan,defaultDecode);
                        break;
                    case 3:
                        parameters = getParameters(scan,defaultBruteForce);
                        break;
                    case 4:
                        parameters = getParameters(scan,defaultStatAnalysis);
                        break;
                    case 5:
                        System.out.println("Application complete! Goodbye, see you again.");
                        System.exit(0);
                }
                // -- Передача выбранной команды в виде параметра в экземпляр класса ConsoleView --
                consoleview = new ConsoleView(parameters);
                // -- Передача экземпляра класса ConsoleView в виде параметра в исполняющий класс Run (Запуск) --
                new Run(consoleview);
            }
        }
    }

    // -- Метод для получения параметров --
    private List<String> getParameters(Scanner scan,String[] defaultParameters) {
        List<String> parameters = new ArrayList<>(List.of(defaultParameters));
        if(parameters.get(0) == "ENCODE" || parameters.get(0) == "DECODE") {
            System.out.println("Enter the ENCRYPTION KEY");
            parameters.add(String.valueOf(Validate.inputValidation(scan, 1, CryptoAlphabet.ALPHABET_SIZE)));
        }
        return parameters;
    }
}

