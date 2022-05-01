package com.hotel.services.helpers;

import com.hotel.dto.admin.GroupObjectDto;
import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.dto.portal.AddressDto;
import com.hotel.entites.Address;
import com.hotel.entites.Group;
import com.hotel.repositories.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        Address address = new Address();
        address.setAddress1(requestDto.getGroup().getAddress().getAddress1());
        address.setAddress2(requestDto.getGroup().getAddress().getAddress2());
        address.setType(requestDto.getGroup().getAddress().getType());
        address.setCity(requestDto.getGroup().getAddress().getCity());
        address.setState(requestDto.getGroup().getAddress().getState());
        address.setCountry(requestDto.getGroup().getAddress().getCountry());
        address.setPinCode(requestDto.getGroup().getAddress().getPinCode());
        group.setAddress(address);

        Group savedGroupRepo = groupRepository.save(group);

        log.info("Saved Into Database {}", savedGroupRepo);

        GroupResponseDto responseDto = new GroupResponseDto();
        GroupObjectDto savedGroup = new GroupObjectDto();
        AddressDto savedGroupAddress = new AddressDto();
        savedGroupAddress.setAddress1(savedGroupRepo.getAddress().getAddress1());
        savedGroupAddress.setAddress2(savedGroupRepo.getAddress().getAddress2());
        savedGroupAddress.setType(savedGroupRepo.getAddress().getType());
        savedGroupAddress.setCity(savedGroupRepo.getAddress().getCity());
        savedGroupAddress.setState(savedGroupRepo.getAddress().getState());
        savedGroupAddress.setCountry(savedGroupRepo.getAddress().getCountry());
        savedGroupAddress.setPinCode(savedGroupRepo.getAddress().getPinCode());

        savedGroup.setAddress(savedGroupAddress);
        savedGroup.setStatus(savedGroupRepo.getStatus());
        savedGroup.setName(savedGroupRepo.getName());

        responseDto.setGroup(savedGroup);

        return responseDto;
    }

    public List<GroupResponseDto> findAll() {
        return null;
    }

    public GroupResponseDto findById(Integer id) {
        return null;
    }

    public void deleteById(Integer id) {

    }

    public GroupResponseDto modifyGroup(GroupRequestDto requestDto) {
        return null;
    }
}
