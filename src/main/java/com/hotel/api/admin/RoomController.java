package com.hotel.api.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.admin.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Room Controller
 *
 * <pre>
 *  SUPER_ADMIN, HOTEL_ADMIN  — full CRUD
 *  HR_MANAGER, FRONT_DESK    — read-only (GET)
 * </pre>
 *
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
@Tag(name = "Rooms", description = "Room management")
public class RoomController {

    private final RoomService roomService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Create room")
    public ResponseEntity<RoomResponseDto> createRoom(@Valid @RequestBody RoomRequestDto dto) {
        return ResponseEntity.ok(roomService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "List all rooms (paginated)")
    public ResponseEntity<List<RoomResponseDto>> getAllRooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(roomService.findAll(page, Math.min(size, 200)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "Get room by ID")
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable Integer id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Update room")
    public ResponseEntity<RoomResponseDto> modifyRoomById(
            @Valid @RequestBody RoomRequestDto dto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(roomService.modify(id, dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Delete room (SUPER_ADMIN only)")
    public ResponseEntity<String> deleteRoomById(@PathVariable Integer id) {
        roomService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully: " + id);
    }
}
