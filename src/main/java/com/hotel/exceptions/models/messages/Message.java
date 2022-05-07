package com.hotel.exceptions.models.messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * An Error {@link Message}
 * @author rgonda
 */
@JsonSubTypes({
        @JsonSubTypes.Type(name = "InternalServerMessage",value = InternalServerMessage.class),
})
public abstract class Message {

}
