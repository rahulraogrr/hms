package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.entites.admin.Group;
import com.hotel.mappers.admin.group.GroupReqDTOMapper;
import com.hotel.mappers.admin.group.GroupResDTOMapper;
import com.hotel.repositories.admin.GroupRepository;
import com.hotel.util.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GroupHelper {
    private final GroupRepository groupRepository;
    private final GroupResDTOMapper groupResDTOMapper;
    private final GroupReqDTOMapper groupReqDTOMapper;

    public GroupHelper(GroupRepository groupRepository, GroupResDTOMapper groupResDTOMapper, GroupReqDTOMapper groupReqDTOMapper) {
        this.groupRepository = groupRepository;
        this.groupResDTOMapper = groupResDTOMapper;
        this.groupReqDTOMapper = groupReqDTOMapper;
    }

    public GroupResponseDto createGroup(GroupRequestDto requestDto) {
        log.info("Create Request {}",requestDto);
        return groupResDTOMapper
                .apply(groupRepository.save(groupReqDTOMapper.apply(requestDto)));
    }

    public List<GroupResponseDto> findAll() {
        return groupRepository.findAll()
                .stream()
                .map(groupResDTOMapper)
                .collect(Collectors.toList());
    }

    public GroupResponseDto findById(Integer id) {
        return groupRepository.findById(id)
                .map(groupResDTOMapper)
                .orElseThrow(RuntimeException::new);
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

        return groupResDTOMapper.apply(groupRepository.save(group));
    }
}