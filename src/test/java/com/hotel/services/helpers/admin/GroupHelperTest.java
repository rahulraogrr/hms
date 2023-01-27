package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.group.GroupObjectDto;
import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.dto.portal.AddressDto;
import com.hotel.mappers.admin.group.GroupReqDTOMapper;
import com.hotel.mappers.admin.group.GroupResDTOMapper;
import com.hotel.repositories.admin.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class GroupHelperTest {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupResDTOMapper groupResDTOMapper;

    @Autowired
    private GroupHelper groupHelperUnderTest;

    @Autowired
    private GroupReqDTOMapper groupReqDTOMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        groupHelperUnderTest = new GroupHelper(groupRepository, groupResDTOMapper,
                groupReqDTOMapper);
    }

    @Test
    void createGroup() {
        GroupResponseDto validGroup = groupHelperUnderTest.createGroup(getValidRequest());

        assertNotNull(validGroup);
        assertTrue(validGroup.getGroup().getId() > 0);
        assertEquals(getValidRequest().getGroup().getName(),validGroup.getGroup().getName());
        assertEquals(getValidRequest().getGroup().getStatus(),validGroup.getGroup().getStatus());

        assertTrue(validGroup.getGroup().getAddress().getId()>0);
        assertEquals(getValidRequest().getGroup().getAddress().getType(),validGroup.getGroup().getAddress().getType());
        assertEquals(getValidRequest().getGroup().getAddress().getAddress1(),validGroup.getGroup().getAddress().getAddress1());
        assertEquals(getValidRequest().getGroup().getAddress().getAddress2(),validGroup.getGroup().getAddress().getAddress2());
        assertEquals(getValidRequest().getGroup().getAddress().getCity(),validGroup.getGroup().getAddress().getCity());
        assertEquals(getValidRequest().getGroup().getAddress().getState(),validGroup.getGroup().getAddress().getState());
        assertEquals(getValidRequest().getGroup().getAddress().getCountry(),validGroup.getGroup().getAddress().getCountry());
        assertEquals(getValidRequest().getGroup().getAddress().getPinCode(),validGroup.getGroup().getAddress().getPinCode());
    }

    private GroupRequestDto getValidRequest() {
        return GroupRequestDto.builder()
                .group(GroupObjectDto.builder()
                        .address(
                                AddressDto.builder()
                                        .type(1)
                                        .address1("pocharam")
                                        .address2("Ghatkesar")
                                        .city("Hyderabad")
                                        .state("Telangana")
                                        .country("India")
                                        .pinCode("500088")
                                        .build()
                        )
                        .name("J.W MARRIOTT")
                        .status(1)
                        .build()
                )
                .build();
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        //GroupResponseDto group = groupHelperUnderTest.findById(2);

        //assertNotNull(group);
        //assertEquals("Taj Hotels",group.getGroup().getName());
        //assertEquals(1,group.getGroup().getAddress());
    }

    @Test
    void deleteById() {

    }

    @Test
    void modifyGroup() {

    }
}