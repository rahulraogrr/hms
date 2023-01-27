package com.hotel.mappers.admin.group;

import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.entites.admin.Group;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GroupResDTOMapper implements Function<Group, GroupResponseDto> {

    private final GroupObjectDTOMapper groupObjectDTOMapper;

    public GroupResDTOMapper(GroupObjectDTOMapper groupObjectDTOMapper) {
        this.groupObjectDTOMapper = groupObjectDTOMapper;
    }

    @Override
    public GroupResponseDto apply(Group group) {
        return new GroupResponseDto(groupObjectDTOMapper.apply(group));
    }
}