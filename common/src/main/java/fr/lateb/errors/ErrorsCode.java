package fr.lateb.errors;


import fr.lateb.util.HttpError;
import fr.lateb.util.IHttpError;
import jakarta.ws.rs.core.Response.Status;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;



public enum ErrorsCode implements IHttpError {
    EXAMPLE_ERROR(BAD_REQUEST, "Example error: %s"),
   BEER_NOT_FOUND(NOT_FOUND, "Beer not found : %s"),
    BEER_ALREADY_EXISTS(BAD_REQUEST, "Beer already exists : %s"),
    ;
    private final HttpError error;

    ErrorsCode(Status status, String message) {
        error = new HttpError(status, message);
    }

    @Override
    public RuntimeException get(Object... args) {
        return error.get(args);
    }

    @Override
    public void throwException(Object... args) {
        throw error.get(args);
    }
}
