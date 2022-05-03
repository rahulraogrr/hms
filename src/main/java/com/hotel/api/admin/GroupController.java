package com.hotel.api.admin;

import com.hotel.dto.admin.GroupRequestDto;
import com.hotel.dto.admin.GroupResponseDto;
import com.hotel.services.admin.GroupService;
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
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> getGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(groupService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteGroupById(@PathVariable Integer id){
        groupService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> modifyGroupById(@RequestBody GroupRequestDto grpReqDto, @PathVariable Integer id){
        return ResponseEntity.ok(groupService.modify(id,grpReqDto));
    }
}