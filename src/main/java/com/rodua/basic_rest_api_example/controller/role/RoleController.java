package com.rodua.basic_rest_api_example.controller.role;

import com.rodua.basic_rest_api_example.dto.role.RoleCreateRequest;
import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import com.rodua.basic_rest_api_example.service.role.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAll() {
        final var roles = service.findAll();

        return ResponseEntity.ok(roles);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDto> create(@RequestBody @Valid RoleCreateRequest request) {
        final var created = service.create(request);

        return ResponseEntity.ok(created);
    }
}
