package com.hotel.services.helpers.admin;

import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.repositories.admin.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupHelperTest {
    private GroupRepository groupRepository;

    private GroupHelper groupHelperUnderTest;

    @BeforeEach
    void setUp(GroupRepository groupRepository){
        MockitoAnnotations.openMocks(this);
        groupHelperUnderTest = new GroupHelper(groupRepository);
    }

    @Test
    void createGroup() {

    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        GroupResponseDto group = groupHelperUnderTest.findById(2);

        assertNotNull(group);
        assertEquals("Taj Hotels",group.getGroup().getName());
        assertEquals(1,group.getGroup().getStatus());
    }

    @Test
    void deleteById() {

    }

    @Test
    void modifyGroup() {

    }
}