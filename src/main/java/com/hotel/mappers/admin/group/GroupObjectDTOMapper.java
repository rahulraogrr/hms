package com.hotel.mappers.admin.group;

import com.hotel.dto.admin.group.GroupObjectDto;
import com.hotel.entites.admin.Group;
import com.hotel.mappers.AddressDTOMapper;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GroupObjectDTOMapper extends GroupObjectDto implements Function<Group, GroupObjectDto> {

    private final AddressDTOMapper addressDTOMapper;

    public GroupObjectDTOMapper(AddressDTOMapper addressDTOMapper) {
        this.addressDTOMapper = addressDTOMapper;
    }

    @Override
    public GroupObjectDto apply(Group group) {
        return new GroupObjectDto(
                group.getId(),
                group.getName(),
                group.getStatus(),
                addressDTOMapper.apply(group.getAddress())
        );
    }
}
