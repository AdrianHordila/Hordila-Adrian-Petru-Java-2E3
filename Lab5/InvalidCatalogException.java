package com.bibliography.exception;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String message) {
        super(message);
    }
    public InvalidCatalogException(Exception ex) {
        super(ex);
    }
}