package com.hotel.api.admin;

import com.hotel.dto.admin.floor.FloorRequestDto;
import com.hotel.dto.admin.floor.FloorResponseDto;
import com.hotel.services.admin.FloorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Floor Controller
 *
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/floors")
@Tag(name = "floors", description = "FloorController")
public class FloorController {

    private final FloorService floorService;

    FloorController(FloorService floorService){
        this.floorService=floorService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FloorResponseDto> createFloor(@RequestBody FloorRequestDto dto){
        return ResponseEntity.ok(floorService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FloorResponseDto>> getAllFloors(){
        return ResponseEntity.ok(floorService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FloorResponseDto> getFloorById(@PathVariable Integer id){
        return ResponseEntity.ok(floorService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteFloorById(@PathVariable Integer id){
        floorService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully : "+id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FloorResponseDto> modifyFloorById(@RequestBody FloorRequestDto dto,
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(floorService.modify(id,dto));
    }
}