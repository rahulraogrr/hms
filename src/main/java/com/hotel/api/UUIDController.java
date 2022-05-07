package com.hotel.api;

import com.hotel.entites.UUIDTest;
import com.hotel.repositories.UUIDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/uuid")
public class UUIDController {

    @Autowired
    private UUIDRepo uuidRepo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UUIDTest> generateUUID(@RequestBody UUIDTest uuidTest){
        return ResponseEntity.ok(uuidRepo.save(uuidTest));
    }

}
