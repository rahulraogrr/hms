package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.GroupObjectDto;
import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.entites.admin.Group;
import com.hotel.repositories.GroupRepository;
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
        return getGroupResponseDto(groupRepository.findById(id).orElseThrow(RuntimeException::new));
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
        GroupResponseDto existingGroup = findById(requestDto.getGroup().getId());
        existingGroup.setGroup(requestDto.getGroup());

        Group group = new Group();
        group.setStatus(existingGroup.getGroup().getStatus());
        group.setName(existingGroup.getGroup().getName());
        group.setAddress(CommonCode.getAddress(existingGroup.getGroup().getAddress()));

        return getGroupResponseDto(groupRepository.save(group));
    }
}