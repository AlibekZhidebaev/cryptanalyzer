package com.javarush.cryptanalyzer.zhidebaev.exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException() {
        super();
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(String message) {
        super(message);
      //  System.out.println(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
