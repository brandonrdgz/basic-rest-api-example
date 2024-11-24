package com.rodua.basic_rest_api_example.dto.user;

import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserOutputDto {
    private Long id;
    private String username;
    private Set<RoleDto> roles;
}
