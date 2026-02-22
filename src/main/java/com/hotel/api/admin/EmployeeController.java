package com.hotel.api.admin;

import com.hotel.dto.admin.employee.EmployeeRequestDto;
import com.hotel.dto.admin.employee.EmployeeResponseDto;
import com.hotel.services.admin.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Employee Controller
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "employees", description = "EmployeeController")
public class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size){
        return ResponseEntity.ok(employeeService.findAll(page, size));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully : "+id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> modifyEmployeeById(@RequestBody EmployeeRequestDto dto,
                                                            @PathVariable Long id){
        return ResponseEntity.ok(employeeService.modify(id,dto));
    }

}
