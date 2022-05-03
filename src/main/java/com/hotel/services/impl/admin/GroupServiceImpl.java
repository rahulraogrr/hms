package com.hotel.services.impl.admin;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.services.admin.GroupService;
import com.hotel.services.helpers.admin.GroupHelper;
import com.hotel.services.validators.admin.GroupValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GroupServiceImpl")
@Slf4j
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupHelper groupHelper;

    @Autowired
    private GroupValidator groupValidator;

    @Override
    public GroupResponseDto create(GroupRequestDto requestDto) {
        log.info("Creating Group : {}",requestDto.getGroup().getId());
        groupValidator.validateRequest(requestDto);
        return groupHelper.createGroup(requestDto);
    }

    @Override
    public List<GroupResponseDto> findAll() {
        log.info("Browse All Groups");
        return groupHelper.findAll();
    }

    @Override
    public GroupResponseDto findById(Integer id) {
        log.info("Find Group By ID : {}",id);
        return groupHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Delete Group By ID : {}",id);
        groupHelper.deleteById(id);
    }

    @Override
    public GroupResponseDto modify(Integer id, GroupRequestDto requestDto) {
        log.info("Modify Group By ID : {}",id);
        groupValidator.validateRequest(requestDto);
        return groupHelper.modifyGroup(requestDto);
    }
}