package com.hotel.exceptions;

/**
 * Thrown when a requested resource cannot be found in the database.
 * Maps to HTTP 404 Not Found via {@link GlobalExceptionHandler}.
 *
 * @author rgonda
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " not found with id: " + id);
    }
}
