package com.rodua.basic_rest_api_example.dto.user;

import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Set<RoleDto> roles;
}
