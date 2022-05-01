package com.hotel.services.impl;

import com.hotel.entites.Group;
import com.hotel.repositories.GroupRepository;
import com.hotel.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GroupServiceImpl")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Integer id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group modify(Integer id, Group group) {
        //TODO: Group Modify Service
        return null;
    }
}