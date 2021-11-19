package com.postserver.Exceptions;
import java.lang.Exception;

public class AccountExceptions extends Exception{
    public AccountExceptions(String message, Throwable er){
        super(message, er);
    }
    public AccountExceptions(String message){
        super(message);
    }
}