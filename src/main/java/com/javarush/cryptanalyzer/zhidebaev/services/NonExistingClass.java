package com.javarush.cryptanalyzer.zhidebaev.services;

import com.javarush.cryptanalyzer.zhidebaev.entity.Result;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class NonExistingClass implements Function {
    @Override
    public Result execute(String[] commandParameters){

        System.out.println("Non existing Class");

        return new Result(ResultCode.OK);
    }
}
