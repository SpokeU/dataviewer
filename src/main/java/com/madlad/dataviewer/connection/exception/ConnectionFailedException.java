package com.madlad.dataviewer.connection.exception;

public class ConnectionFailedException extends RuntimeException {
    public ConnectionFailedException(Throwable e) {
        super(e);
    }
}
