package com.hotel.services.helpers;

import com.hotel.dto.admin.GroupObjectDto;
import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.entites.Group;
import com.hotel.repositories.GroupRepository;
import com.hotel.util.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class GroupHelper {

    @Autowired
    private GroupRepository groupRepository;

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
        Group savedGroupRepo = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        return getGroupResponseDto(savedGroupRepo);
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

    public GroupResponseDto modifyGroup(GroupRequestDto requestDto) {
        //TODO: Modify
        return null;
    }
}