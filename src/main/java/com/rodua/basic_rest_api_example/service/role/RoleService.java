package com.rodua.basic_rest_api_example.service.role;

import com.rodua.basic_rest_api_example.dto.role.RoleCreateRequest;
import com.rodua.basic_rest_api_example.dto.role.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto create(RoleCreateRequest request);
}
