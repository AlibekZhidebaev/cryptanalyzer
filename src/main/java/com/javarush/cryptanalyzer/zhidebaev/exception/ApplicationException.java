package com.javarush.cryptanalyzer.zhidebaev.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException() {
        super("not found");
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);

    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return getMessage().toString();
    }
}
