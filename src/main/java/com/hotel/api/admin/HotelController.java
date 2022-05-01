package com.hotel.api.admin;

import com.hotel.dto.admin.HotelRequestDto;
import com.hotel.dto.admin.HotelResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@Tag(name = "HOTELS", description = "HotelController")
public class HotelController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> createGroup(@RequestBody HotelRequestDto dto){
        return ResponseEntity.ok(null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HotelResponseDto>> getAllGroups(){
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> getGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> deleteGroupById(@PathVariable Integer id){
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> modifyGroupById(@RequestBody HotelRequestDto dto,
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(null);
    }
}