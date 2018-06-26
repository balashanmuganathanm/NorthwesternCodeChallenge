package com.bala.todolistmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2370451751518940994L;

	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
