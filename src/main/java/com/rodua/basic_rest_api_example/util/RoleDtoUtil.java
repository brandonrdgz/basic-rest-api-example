package com.rodua.basic_rest_api_example.util;

import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class RoleDtoUtil {
    private RoleDtoUtil() {}

    public static GrantedAuthority dtoToGrantedAuthority(RoleDto role) {
        return new SimpleGrantedAuthority(role.getName());
    }
}
