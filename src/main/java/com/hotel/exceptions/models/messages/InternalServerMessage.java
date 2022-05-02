package com.hotel.exceptions.models.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InternalServerMessage extends Message{
    @Schema(
            title = "traceId",
            name = "traceId",
            description = "Error Trace Id"
    )
    private String traceId;

    @Schema(title = "defaultMessage",
            description = "defaultMessage",
            required = true,
            example = "Internal Server Error. We have logged the error and we will work hard to make it right")
    private String defaultMessage;
}
