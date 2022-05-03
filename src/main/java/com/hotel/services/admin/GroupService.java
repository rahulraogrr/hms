package com.hotel.services.admin;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.services.CrudService;

/**
 * A Group
 */
public interface GroupService extends CrudService<GroupRequestDto, GroupResponseDto, Integer> {
}