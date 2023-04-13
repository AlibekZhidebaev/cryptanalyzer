package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.constants.FileConstants;
import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class BruteForcer implements Function {
    String sourceFile = FileConstants.ENCODED_FILE;
    String destinationFile = FileConstants.OUTPUT_FILE;
    int key =3;
    @Override
    public Result execute(String[] commandParameters){
        try {
            System.out.println("works BruteForcer");
        }catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("BruteForcer error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
