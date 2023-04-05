package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class Encoder implements Function{
    @Override
    public Result execute() {
        try {
            System.out.println("works Encode");
        }catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("Encode error", ex));
        }
        return new Result(ResultCode.OK);
    }
}
