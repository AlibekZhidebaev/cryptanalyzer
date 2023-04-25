package com.javarush.cryptanalyzer.zhidebaev.entity;

import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class Result {

    private final ResultCode resultcode;
    private ApplicationException applicationexception = new ApplicationException();

    public Result(ResultCode resultcode) {
        this.resultcode = resultcode;
    }

    public Result(ResultCode resultcode, ApplicationException applicationexception) {
        this.resultcode = resultcode;
        this.applicationexception = applicationexception;
    }
    @Override
    public String toString() {
        return "Operation status: " + resultcode + "\n"
                + "ERROR: " + applicationexception;
    }
}
