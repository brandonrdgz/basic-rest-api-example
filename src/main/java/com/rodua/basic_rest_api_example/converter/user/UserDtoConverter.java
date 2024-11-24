package com.rodua.basic_rest_api_example.converter.user;

import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import com.rodua.basic_rest_api_example.dto.user.UserCreateRequest;
import com.rodua.basic_rest_api_example.dto.user.UserDto;
import com.rodua.basic_rest_api_example.dto.user.UserOutputDto;
import com.rodua.basic_rest_api_example.model.Role;
import com.rodua.basic_rest_api_example.model.User;

import java.util.Set;

public class UserDtoConverter {
    public UserDto modelToDto(final User user, final Set<RoleDto> roles) {
        return UserDto
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }

    public User dtoToModel(final UserDto dto, final Set<Role> roles) {
        return User
                .builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .roles(roles)
                .build();
    }

    public UserDto createRequestDtoToDto(final UserCreateRequest createRequestDto, final RoleDto roleDto) {
        return UserDto
                .builder()
                .username(createRequestDto.getUsername())
                .password(createRequestDto.getPassword())
                .roles(Set.of(roleDto))
                .build();
    }

    public UserOutputDto dtoToOutputDto(final UserDto dto) {
        return UserOutputDto
                .builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .roles(dto.getRoles())
                .build();
    }
}
