package com.hotel.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * API Error Response
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    @Schema(title = "status",
            name = "status",
            description = "Error Status",
            example = "400"
    )
    private int status;

    @Schema(title = "timestamp",
            name = "timestamp",
            description = "Error Timestamp",
            example = "2021-08-10 03:48:58"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
}