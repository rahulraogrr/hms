package com.hotel.api.admin;

import com.hotel.dto.admin.floor.FloorRequestDto;
import com.hotel.dto.admin.floor.FloorResponseDto;
import com.hotel.services.admin.FloorService;
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
 * Floor Controller
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
@RequestMapping("/api/v1/floors")
@RequiredArgsConstructor
@Tag(name = "Floors", description = "Floor management")
public class FloorController {

    private final FloorService floorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Create floor")
    public ResponseEntity<FloorResponseDto> createFloor(@Valid @RequestBody FloorRequestDto dto) {
        return ResponseEntity.ok(floorService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "List all floors (paginated)")
    public ResponseEntity<List<FloorResponseDto>> getAllFloors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(floorService.findAll(page, Math.min(size, 200)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "Get floor by ID")
    public ResponseEntity<FloorResponseDto> getFloorById(@PathVariable Integer id) {
        return ResponseEntity.ok(floorService.findById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Update floor")
    public ResponseEntity<FloorResponseDto> modifyFloorById(
            @Valid @RequestBody FloorRequestDto dto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(floorService.modify(id, dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Delete floor (SUPER_ADMIN only)")
    public ResponseEntity<String> deleteFloorById(@PathVariable Integer id) {
        floorService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully: " + id);
    }
}
