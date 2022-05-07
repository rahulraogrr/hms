package com.hotel.api.admin;

import com.hotel.dto.admin.hotel.HotelRequestDto;
import com.hotel.dto.admin.hotel.HotelResponseDto;
import com.hotel.services.admin.HotelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Hotel Controller
 * @author rgonda
 */
@RestController
@RequestMapping("/api/v1/hotels")
@Tag(name = "hotels", description = "HotelController")
public class HotelController {

    private final HotelService hotelService;

    HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> createHotel(@RequestBody HotelRequestDto dto){
        return ResponseEntity.ok(hotelService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HotelResponseDto>> getAllHotels(){
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> getHotelById(@PathVariable Integer id){
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteGroupById(@PathVariable Integer id){
        hotelService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully : "+id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelResponseDto> modifyHotelById(@RequestBody HotelRequestDto dto,
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(hotelService.modify(id,dto));
    }
}