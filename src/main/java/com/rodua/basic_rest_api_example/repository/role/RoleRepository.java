package com.rodua.basic_rest_api_example.repository.role;

import com.rodua.basic_rest_api_example.dto.role.RoleDto;

import java.util.List;

public interface RoleRepository {
    List<RoleDto> findAll();
    RoleDto findById(long id);
    RoleDto findByName(String name);
    RoleDto save(RoleDto role);
}
