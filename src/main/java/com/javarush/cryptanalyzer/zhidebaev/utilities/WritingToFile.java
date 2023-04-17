package com.javarush.cryptanalyzer.zhidebaev.utilities;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingToFile {
    private Path pathFile;
    @SuppressWarnings("unused")
    private String textToWrite;

    public WritingToFile(String outputFile, String textToWrite) {
        this.pathFile = Paths.get(outputFile);
        this.textToWrite = textToWrite;
        try {
            Files.writeString(pathFile, textToWrite, Charset.defaultCharset());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error writing to file", "File write error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
