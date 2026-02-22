package com.hotel.services.validators.admin;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.services.validators.ServiceValidatorGeneric;
import org.springframework.stereotype.Component;

@Component
public class GroupValidator implements ServiceValidatorGeneric<GroupRequestDto> {

    private static final int MAX_NAME_LENGTH = 20;

    @Override
    public void validateRequest(GroupRequestDto requestDto) {
        if (requestDto == null || requestDto.getGroup() == null) {
            throw new IllegalArgumentException("Group request must not be null");
        }

        String name = requestDto.getGroup().getName();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Group name must not be blank");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Group name must not exceed " + MAX_NAME_LENGTH + " characters");
        }
    }
}
