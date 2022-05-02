package com.hotel.exceptions.models.messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(name = "InternalServerMessage",value = InternalServerMessage.class),
})
public abstract class Message {

}
