package me.dio.santander_api_projeto.controller.exception;

public class CardNumberException extends IllegalArgumentException{

    public CardNumberException(String message) {
        super(message);
    }

}

