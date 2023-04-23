package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFromFile {
    private final Path pathInputFile;
    private final String inputFile;
    private char[] textChars;

    public ReadingFromFile(String inputFile) throws ApplicationException {
        this.inputFile = inputFile;
        Path pathFile = Paths.get(inputFile);
        // -- Проверка файла на присутствие и доступность --
        boolean isThisFileAndDoesExist = Files.isRegularFile(pathFile) && Files.exists(pathFile);
        if(isThisFileAndDoesExist) this.pathInputFile = pathFile;
        // -- В случае недоступности файла бросаем исключение --
        else throw new ApplicationException("File with path: \"" + inputFile +"\" not found!");
    }

    // -- Метод, возвращающий содержание файла в виде текстовой строки --
    public String getFileAsString()  throws ApplicationException {
        //inputFileValidation(inputFile);
        String textString;
        try {
            textString = Files.readString(pathInputFile, Charset.defaultCharset());
        } catch (IOException e) {
            // -- Ошибка при чтении файла --
            throw new ApplicationException("Error reading file: \"" + inputFile +"\"");
        }
        return textString;
    }
    // -- Метод, возвращающий содержание файла в виде массива символов --
    public char[] getFileAsArrayOfCharacters() {
        textChars = getFileAsString().toCharArray();
        return textChars;
    }

    // -- Метод, возвращающий содержание файла в виде массива символов в нижнем регистре --
    public char[] getFileAsArrayOfCharactersToLowerCase() {
        textChars = getFileAsString().toLowerCase().toCharArray();
        return textChars;
    }
}
