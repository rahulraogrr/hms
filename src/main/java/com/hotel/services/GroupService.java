package com.hotel.services;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;

/**
 * A Group
 */
public interface GroupService extends CrudService<GroupRequestDto, GroupResponseDto, Integer> {
}