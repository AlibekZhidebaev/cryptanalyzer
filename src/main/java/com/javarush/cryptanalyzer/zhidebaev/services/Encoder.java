package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;
import com.javarush.cryptanalyzer.zhidebaev.utilities.Encode;

import java.io.FileReader;
import java.io.FileWriter;

public class Encoder implements Function{

    @Override
    public Result execute(String[] commandParameters) {
        System.out.println("works Encode");
        try (FileReader reader = new FileReader(commandParameters[0]); // -- Получение пути к файлу для чтения символов --
             FileWriter writer = new FileWriter(commandParameters[1])) // -- Получение пути к файлу для записи символов --
        {
            int key = Integer.parseInt(commandParameters[2]); // -- Получение и преобразование ключа в целое число --
            // -- Чтение файла до последнего символа --
            while (reader.ready()) {
                // --Посимвольное чтение --
                char symbol = (char) reader.read();
                // -- Кодирование прочтенного символа с помощью метода экземпляра класса Encode --
                writer.write(new Encode().encode(symbol, key));
            }

        } catch (Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Encode error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
