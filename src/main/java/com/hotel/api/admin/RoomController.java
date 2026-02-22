package com.hotel.api.admin;

import com.hotel.dto.admin.room.RoomRequestDto;
import com.hotel.dto.admin.room.RoomResponseDto;
import com.hotel.services.admin.RoomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Room Controller
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/rooms")
@Tag(name = "rooms", description = "RoomController")
public class RoomController {
    private final RoomService roomService;
    RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody RoomRequestDto dto){
        return ResponseEntity.ok(roomService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoomResponseDto>> getAllRooms(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size){
        return ResponseEntity.ok(roomService.findAll(page, size));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable Integer id){
        return ResponseEntity.ok(roomService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteRoomById(@PathVariable Integer id){
        roomService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully : "+id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomResponseDto> modifyRoomById(@RequestBody RoomRequestDto dto,
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(roomService.modify(id,dto));
    }

}
