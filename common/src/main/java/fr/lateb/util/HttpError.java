package fr.lateb.util;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response.Status;

import java.util.function.Supplier;

import static jakarta.ws.rs.core.Response.status;

public class HttpError implements Supplier<RuntimeException>, IHttpError {
    private final Status status;
    private final String message;

    public HttpError(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    private RuntimeException createError(Object... args) {
        return new WebApplicationException(
                status(status)
                        .entity(new ErrorInfo(String.format(message, args)))
                        .build());
    }

    @Override
    public RuntimeException get() {
        return createError();
    }

    @Override
    public RuntimeException get(Object... args) {
        return createError(args);
    }

    @Override
    public void throwException(Object... args) {
        throw get(args);
    }
}
