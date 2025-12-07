package me.dio.santander_api_projeto.controller.exception;

public class AccountNumberException extends IllegalArgumentException {
    
    public AccountNumberException(String message) {
        super(message);
    }

}
