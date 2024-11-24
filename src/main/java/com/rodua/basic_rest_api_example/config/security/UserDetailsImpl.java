package com.rodua.basic_rest_api_example.config.security;

import com.rodua.basic_rest_api_example.dto.user.UserDto;
import com.rodua.basic_rest_api_example.util.RoleDtoUtil;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public static UserDetailsImpl buildUserDetails(UserDto user) {
        final var authorities = user.getRoles()
                .stream()
                .map(RoleDtoUtil::dtoToGrantedAuthority)
                .toList();

        return UserDetailsImpl
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
