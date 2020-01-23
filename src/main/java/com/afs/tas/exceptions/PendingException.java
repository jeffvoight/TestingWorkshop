package com.afs.tas.exceptions;

public class PendingException extends RuntimeException {

    public PendingException(String message) {
        super(message);
    }

    public PendingException(){
        super("This step not yet implemented.");
    }
}
