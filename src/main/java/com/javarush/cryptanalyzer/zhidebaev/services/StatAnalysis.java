package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class StatAnalysis implements Function {
    @Override
    public Result execute() {
        try {
            System.out.println("works StatAnalysis");
        }catch(Exception ex) {
            return new Result(ResultCode.ERROR, new ApplicationException("StatAnalysis", ex));
        }
        return new Result(ResultCode.OK);
    }
}
