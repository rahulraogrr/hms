package com.hotel.api.admin;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.services.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "GROUPS", description = "GroupController")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto dto){
        return ResponseEntity.ok(groupService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupResponseDto>> getAllGroups(){
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> getGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> deleteGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> modifyGroupById(@RequestBody GroupRequestDto grpReqDto, @PathVariable Integer id){
        return ResponseEntity.ok(null);
    }
}