package br.com.maximilianoalves.error;

public class ExpiredJwtException extends RuntimeException {

    public ExpiredJwtException(String message) {
        super(message);
    }
}
