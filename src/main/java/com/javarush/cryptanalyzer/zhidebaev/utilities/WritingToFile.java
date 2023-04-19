package com.javarush.cryptanalyzer.zhidebaev.utilities;

import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingToFile {

    // -- Метод, записывающий указанную текстовую строку в указанный файл --
    public WritingToFile(String outputFile, String textToWrite) throws ApplicationException {
        Path pathFile = Paths.get(outputFile);
        try {
            Files.writeString(pathFile, textToWrite, Charset.defaultCharset());
        } catch (IOException e) {
            // -- Ошибка при записи в файл --
            throw new ApplicationException("Error writing to file: \"" + outputFile +"\"");
        }
    }
}
