package com.hotel.api.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.admin.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Department Controller
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/departments")
@Tag(name = "departments", description = "DepartmentController")
public class DepartmentController {
    private final DepartmentService departmentService;
    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentRequestDto dto){
        return ResponseEntity.ok(departmentService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Integer id){
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id){
        departmentService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully : "+id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDto> modifyDepartmentById(@RequestBody DepartmentRequestDto dto,
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(departmentService.modify(id,dto));
    }

}
