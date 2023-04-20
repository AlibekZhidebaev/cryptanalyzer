package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class NonExistingClass implements Function {
    @Override
    public Result execute(String[] commandParameters) {

        return new Result(ResultCode.ERROR, new ApplicationException("No such command"));
    }
}
