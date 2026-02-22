package com.hotel.api.admin;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.services.admin.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Group Controller
 * @author rgonda
 */
@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "groups", description = "GroupController")
public class GroupController {
    private final GroupService groupService;
    GroupController(GroupService groupService){
        this.groupService=groupService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto dto){
        return ResponseEntity.ok(groupService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GroupResponseDto>> getAllGroups(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size){
        return ResponseEntity.ok(groupService.findAll(page, size));
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
    public ResponseEntity<GroupResponseDto> modifyGroupById(@RequestBody GroupRequestDto dto, @PathVariable Integer id){
        return ResponseEntity.ok(groupService.modify(id,dto));
    }
}