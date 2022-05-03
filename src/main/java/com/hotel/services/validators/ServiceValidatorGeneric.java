package com.hotel.services.validators;

/**
 *  Validate Request Generic
 *
 * @param <DTO> Request Data Transfer Object
 */
public interface ServiceValidatorGeneric<DTO> {
    void validateRequest(DTO dto);
}