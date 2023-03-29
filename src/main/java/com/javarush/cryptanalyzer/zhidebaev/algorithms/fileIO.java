package com.javarush.cryptanalyzer.zhidebaev.algorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileIO {
    String src = "files//input.txt";
    String dest = "files//output.txt";

    public fileIO() throws IOException {
        try (
                FileReader reader = new FileReader(src);
                FileWriter writer = new FileWriter(dest))
        {
            char[] buffer = new char[65536]; // 64Kb
            while (reader.ready())
            {
                int real = reader.read(buffer);
                writer.write(buffer, 0, real);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
