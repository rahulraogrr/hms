package com.hotel.services.admin;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.services.CrudService;

/**
 * A Group
 */
public interface GroupService extends CrudService<GroupRequestDto, GroupResponseDto, Integer> {
}