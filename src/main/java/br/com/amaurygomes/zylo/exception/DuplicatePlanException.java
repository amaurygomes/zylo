package br.com.amaurygomes.zylo.exception;

public class DuplicatePlanException extends RuntimeException {
    public DuplicatePlanException(){super("A plan with the provided name already exists. Please try again with a different name.");}
    public DuplicatePlanException(String message) {
        super(message);
    }
}
