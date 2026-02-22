package com.hotel.constants;

import lombok.experimental.UtilityClass;

/**
 * Status constants used across all entities.
 *
 * <p>Replace raw int literals (e.g. {@code status = 1}) with these named
 * constants to improve readability and eliminate magic numbers.</p>
 *
 * <p>Usage example:
 * <pre>
 *   hotel.setStatus(StatusConstants.ACTIVE);
 * </pre>
 * </p>
 *
 * @author rgonda
 */
@UtilityClass
public class StatusConstants {

    /** Entity is active and operational. */
    public static final int ACTIVE = 1;

    /** Entity is inactive / soft-disabled. */
    public static final int INACTIVE = 0;
}
