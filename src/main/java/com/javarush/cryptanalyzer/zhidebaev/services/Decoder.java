package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Decode;


import java.io.FileReader;
import java.io.FileWriter;

public class Decoder implements Function{
    // -- Путь к файлу для чтения символов --
    String sourceFile = FileConstants.ENCODED_FILE;
    // -- Путь к файлу для записи символов --
    String destinationFile = FileConstants.OUTPUT_FILE;
    int key =3;

    @Override
    public Result execute(String[] commandParameters) {
        System.out.println("works Decode");
        try (FileReader reader = new FileReader(commandParameters[0]); // -- Получение пути к файлу для чтения символов --
             FileWriter writer = new FileWriter(commandParameters[1])) // -- Получение пути к файлу для записи символов --
        {
            int key = Integer.parseInt(commandParameters[2]); // -- Получение и преобразование ключа в целое число --

            // -- Чтение файла до последнего символа --
            while (reader.ready()) {
                // --Посимвольное чтение --
                char symbol = (char) reader.read();
                // -- Декодирование прочтенного символа с помощью метода экземпляра класса Decode --
                writer.write(new Decode().decode(symbol, key));
            }

        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Decode error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
