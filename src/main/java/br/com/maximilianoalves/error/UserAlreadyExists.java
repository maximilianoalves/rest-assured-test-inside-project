package br.com.maximilianoalves.error;

import lombok.Data;

@Data
public class UserAlreadyExists {

    private UserAlreadyExists(){}

    private String message;
}
