package com.hotel.services.helpers.admin;

import com.hotel.repositories.admin.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupHelperTest {
    private GroupRepository groupRepository;

    private GroupHelper groupHelperUnderTest;

    @BeforeEach
    void setUp(){
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

    }

    @Test
    void deleteById() {

    }

    @Test
    void modifyGroup() {

    }
}