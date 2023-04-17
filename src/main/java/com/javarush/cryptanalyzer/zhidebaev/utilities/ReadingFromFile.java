package com.javarush.cryptanalyzer.zhidebaev.utilities;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFromFile {
    private Path pathInputFile;
    private boolean isThisFileAndDoesExist;
    private List<String> textList;
    private String textString;
    private char[] textChars;

    public ReadingFromFile(String inputFile) {

        Path pathFile = Paths.get(inputFile);
        isThisFileAndDoesExist = Files.isRegularFile(pathFile) && Files.exists(pathFile);
        if(isThisFileAndDoesExist) this.pathInputFile = pathFile;
        else ErrorMessage("The file does not exist! Check the file path!");
    }

    // -- Метод, возвращающий содержание файла в виде текстовой строки --

    public String getFileAsString() {

        try {
            textString = Files.readString(pathInputFile, Charset.defaultCharset());
        } catch (IOException e) {
            ErrorMessage("Error reading file as string");
        }
        return textString;
    }

    // -- Метод, возвращающий содержание файла в виде списка строк --

    public List <String> getFileAsList() {
        try {
            textList = Files.readAllLines(pathInputFile,Charset.defaultCharset());
        } catch (IOException e) {
            ErrorMessage("Error while reading file as list of strings!");
        }
        return textList;
    }

    // -- Метод, возвращающий содержание файла в виде массива символов --

    public char[] getFileAsArrayOfCharacters() {
        textChars = getFileAsString().toCharArray();
        return textChars;
    }

    // -- Метод вывода информации об ошибке --

    public void ErrorMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(),	message, "File read error!", JOptionPane.ERROR_MESSAGE);
    }
}
