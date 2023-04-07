package com.javarush.cryptanalyzer.zhidebaev.entity;

import com.javarush.cryptanalyzer.zhidebaev.exception.ApplicationException;
import com.javarush.cryptanalyzer.zhidebaev.repository.ResultCode;

public class Result {

    private ResultCode resultcode;
    @Override
    public String toString() {
        return "Operation completed successfully = " + resultcode + "\n"
                + "ERROR: " + applicationexception;
    }

    private ApplicationException applicationexception;

    public ResultCode getResultcode() {
        return resultcode;
    }

    public ApplicationException getApplicationexception() {
        return applicationexception;
    }

    public Result(ResultCode resultcode) {
        super();
        this.resultcode = resultcode;
    }

    public Result(ResultCode resultcode, ApplicationException applicationexception) {
        super();
        this.resultcode = resultcode;
        this.applicationexception = applicationexception;
    }
}
