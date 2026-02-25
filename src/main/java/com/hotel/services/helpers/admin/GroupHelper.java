package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.group.GroupObjectDto;
import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.dto.portal.AddressDto;
import com.hotel.entities.admin.Address;
import com.hotel.entities.admin.Group;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repositories.admin.GroupRepository;
import com.hotel.services.helpers.CrudServiceHelperGeneric;
import com.hotel.util.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GroupHelper implements CrudServiceHelperGeneric<GroupRequestDto, GroupResponseDto, Integer> {

    private final GroupRepository groupRepository;

    public GroupHelper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    /**
     * Persists group from request; returns group response
     */
    @Override
    public GroupResponseDto create(GroupRequestDto requestDto) {
        log.info("Request {}",requestDto);
        Group group = new Group();
        group.setStatus(requestDto.getGroup().getStatus());
        group.setName(requestDto.getGroup().getName());
        group.setAddress(CommonCode.getAddress(requestDto.getGroup().getAddress()));

        Group savedGroupRepo = groupRepository.save(group);

        return getGroupResponseDto(savedGroupRepo);
    }

    @Override
    public List<GroupResponseDto> findAll(int page, int size) {
        return groupRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(this::getGroupResponseDto)
                .collect(Collectors.toList());
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

    @Override
    public boolean deleteById(Integer id) {
        groupRepository.deleteById(id);
        return true;
    }

    @Override
    public GroupResponseDto modify(Integer id, GroupRequestDto requestDto) {
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