package com.hotel.api.admin;

import com.hotel.dto.admin.hotel.HotelRequestDto;
import com.hotel.dto.admin.hotel.HotelResponseDto;
import com.hotel.services.admin.HotelService;
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
 * Hotel Controller
 *
 * <pre>
 *  SUPER_ADMIN, HOTEL_ADMIN  — full CRUD
 *  HR_MANAGER, FRONT_DESK    — read-only (GET)
 * </pre>
 *
 * @author rgonda
 */
@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
@Tag(name = "Hotels", description = "Hotel management")
public class HotelController {

    private final HotelService hotelService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Create hotel")
    public ResponseEntity<HotelResponseDto> createHotel(@Valid @RequestBody HotelRequestDto dto) {
        return ResponseEntity.ok(hotelService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "List all hotels (paginated)")
    public ResponseEntity<List<HotelResponseDto>> getAllHotels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(hotelService.findAll(page, Math.min(size, 200)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "Get hotel by ID")
    public ResponseEntity<HotelResponseDto> getHotelById(@PathVariable Integer id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN')")
    @Operation(summary = "Update hotel")
    public ResponseEntity<HotelResponseDto> modifyHotelById(
            @Valid @RequestBody HotelRequestDto dto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(hotelService.modify(id, dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Delete hotel (SUPER_ADMIN only)")
    public ResponseEntity<String> deleteHotelById(@PathVariable Integer id) {
        hotelService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully: " + id);
    }
}
