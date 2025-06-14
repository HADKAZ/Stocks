package fr.lateb.util;

public interface IHttpError {
    RuntimeException get(Object... args);

    void throwException(Object... args);
}
