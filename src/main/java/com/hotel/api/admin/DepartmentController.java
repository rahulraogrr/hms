package com.hotel.api.admin;

import com.hotel.dto.admin.department.DepartmentRequestDto;
import com.hotel.dto.admin.department.DepartmentResponseDto;
import com.hotel.services.admin.DepartmentService;
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
 * Department Controller
 *
 * <pre>
 *  SUPER_ADMIN, HOTEL_ADMIN, HR_MANAGER  — full CRUD
 *  FRONT_DESK                             — read-only (GET)
 * </pre>
 *
 * @author rgonda
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Tag(name = "Departments", description = "Department management")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER')")
    @Operation(summary = "Create department")
    public ResponseEntity<DepartmentResponseDto> createDepartment(@Valid @RequestBody DepartmentRequestDto dto) {
        return ResponseEntity.ok(departmentService.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "List all departments (paginated)")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(departmentService.findAll(page, Math.min(size, 200)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER','FRONT_DESK')")
    @Operation(summary = "Get department by ID")
    public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','HOTEL_ADMIN','HR_MANAGER')")
    @Operation(summary = "Update department")
    public ResponseEntity<DepartmentResponseDto> modifyDepartmentById(
            @Valid @RequestBody DepartmentRequestDto dto,
            @PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.modify(id, dto));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @Operation(summary = "Delete department (SUPER_ADMIN only)")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok("Resource Deleted Successfully: " + id);
    }
}
