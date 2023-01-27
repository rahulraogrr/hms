package com.hotel.mappers.admin.group;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.entites.admin.Group;
import com.hotel.mappers.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GroupReqDTOMapper implements Function<GroupRequestDto, Group> {

    private final GroupObjectDTOMapper groupObjectDTOMapper;
    private final AddressDTO addressDTO;

    public GroupReqDTOMapper(GroupObjectDTOMapper groupObjectDTOMapper, AddressDTO addressDTO) {
        this.groupObjectDTOMapper = groupObjectDTOMapper;
        this.addressDTO = addressDTO;
    }

    @Override
    public Group apply(GroupRequestDto groupRequestDto) {
        return new Group(
                groupRequestDto.getGroup().getId(),
                groupRequestDto.getGroup().getName(),
                groupRequestDto.getGroup().getStatus(),
                addressDTO.apply(groupRequestDto.getGroup().getAddress())
        );
    }
}
