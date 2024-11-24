package com.rodua.basic_rest_api_example.converter.role;

import com.rodua.basic_rest_api_example.dto.role.RoleCreateRequest;
import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import com.rodua.basic_rest_api_example.model.Role;

public class RoleDtoConverter {
    public RoleDto modelToDto(final Role role) {
        return RoleDto
                .builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public Role dtoToModel(final RoleDto dto) {
        return Role
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public RoleDto createRequestToDto(RoleCreateRequest request) {
        return RoleDto
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }
}
