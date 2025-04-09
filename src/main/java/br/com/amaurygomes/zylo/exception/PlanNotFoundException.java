package br.com.amaurygomes.zylo.exception;

public class PlanNotFoundException extends RuntimeException {
    public PlanNotFoundException(){super("The requested plan could not be found. Please try again.");}
    public PlanNotFoundException(String message) {
        super(message);
    }
}
