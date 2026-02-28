package com.hotel.api.admin;

import com.hotel.dto.admin.group.GroupRequestDto;
import com.hotel.dto.admin.group.GroupResponseDto;
import com.hotel.services.admin.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Group Controller
 *
 * <pre>
 *  SUPER_ADMIN  — full CRUD
 *  all others   — read-only (GET)
 * </pre>
 *
 * @author rgonda
 */
@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
@Tag(name = "Groups", description = "Hotel group management")
public class GroupController {

    private final GroupService groupService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Create group (SUPER_ADMIN only)")
    public ResponseEntity<GroupResponseDto> createGroup(@Valid @RequestBody GroupRequestDto dto) {
        return ResponseEntity.ok(groupService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "List all groups (paginated)")
    public ResponseEntity<List<GroupResponseDto>> getAllGroups(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(groupService.findAll(page, Math.min(size, 200)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "Get group by ID")
    public ResponseEntity<GroupResponseDto> getGroupById(@PathVariable Integer id) {
        return ResponseEntity.ok(groupService.findById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Update group (SUPER_ADMIN only)")
    public ResponseEntity<GroupResponseDto> modifyGroupById(
            @Valid @RequestBody GroupRequestDto dto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(groupService.modify(id, dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Delete group (SUPER_ADMIN only)")
    public ResponseEntity<String> deleteGroupById(@PathVariable Integer id) {
        groupService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
