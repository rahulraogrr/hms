package com.hotel.services.impl;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.services.GroupService;
import com.hotel.services.helpers.GroupHelper;
import com.hotel.services.validators.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GroupServiceImpl")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupHelper groupHelper;

    @Autowired
    private GroupValidator groupValidator;

    @Override
    public GroupResponseDto create(GroupRequestDto requestDto) {
        groupValidator.validateRequest(requestDto);
        return groupHelper.createGroup(requestDto);
    }

    @Override
    public List<GroupResponseDto> findAll() {
        return groupHelper.findAll();
    }

    @Override
    public GroupResponseDto findById(Integer id) {
        return groupHelper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        groupHelper.deleteById(id);
    }

    @Override
    public GroupResponseDto modify(Integer id, GroupRequestDto requestDto) {
        groupValidator.validateRequest(requestDto);
        return groupHelper.modifyGroup(requestDto);
    }
}