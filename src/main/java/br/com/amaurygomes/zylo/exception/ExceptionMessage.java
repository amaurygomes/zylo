package br.com.amaurygomes.zylo.exception;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(
        HttpStatus status,
        String message
) {
}
