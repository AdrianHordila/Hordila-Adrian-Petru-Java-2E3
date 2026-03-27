package org.example;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String message) { super(message); }
    public InvalidCatalogException(Throwable cause) { super(cause); }
}