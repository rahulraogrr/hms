package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.group.GroupObjectDto;
import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.admin.Address;
import com.hotel.entites.admin.Group;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.GroupRepository;
import com.hotel.util.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GroupHelper {

    private final GroupRepository groupRepository;

    public GroupHelper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupResponseDto createGroup(GroupRequestDto requestDto) {
        log.info("Request {}",requestDto);
        Group group = new Group();
        group.setStatus(requestDto.getGroup().getStatus());
        group.setName(requestDto.getGroup().getName());
        group.setAddress(CommonCode.getAddress(requestDto.getGroup().getAddress()));

        Group savedGroupRepo = groupRepository.save(group);

        return getGroupResponseDto(savedGroupRepo);
    }

    public List<GroupResponseDto> findAll() {
        List<Group> groupResponseDtos = groupRepository.findAll();
        List<GroupResponseDto> responseDtos = new ArrayList<>();
        groupResponseDtos.forEach(
                groupResponseDto -> responseDtos.add(getGroupResponseDto(groupResponseDto))
        );
        return responseDtos;
    }

    public GroupResponseDto findById(Integer id) {
        return getGroupResponseDto(groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", id)));
    }

    private GroupResponseDto getGroupResponseDto(Group savedGroupRepo) {
        GroupResponseDto responseDto = new GroupResponseDto();
        GroupObjectDto savedGroup = new GroupObjectDto();

        savedGroup.setAddress(CommonCode.getAddressDto(savedGroupRepo.getAddress()));
        savedGroup.setStatus(savedGroupRepo.getStatus());
        savedGroup.setName(savedGroupRepo.getName());
        savedGroup.setId(savedGroupRepo.getId());

        responseDto.setGroup(savedGroup);
        return responseDto;
    }

    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }

    public GroupResponseDto modifyGroup(Integer id, GroupRequestDto requestDto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Group", id));

        group.setName(requestDto.getGroup().getName());
        group.setStatus(requestDto.getGroup().getStatus());

        if (requestDto.getGroup().getAddress() != null) {
            if (group.getAddress() != null) {
                updateAddressInPlace(group.getAddress(), requestDto.getGroup().getAddress());
            } else {
                group.setAddress(CommonCode.getAddress(requestDto.getGroup().getAddress()));
            }
        }

        return getGroupResponseDto(groupRepository.save(group));
    }

    private static void updateAddressInPlace(Address address, AddressDto dto) {
        address.setAddress1(dto.getAddress1());
        address.setAddress2(dto.getAddress2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPinCode(dto.getPinCode());
        address.setType(dto.getType());
    }
}