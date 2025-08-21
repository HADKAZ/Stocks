package fr.lateb.util;

public class BeerNotFoundError extends Exception {
    public BeerNotFoundError(String message) {
        super(message);
    }
}
