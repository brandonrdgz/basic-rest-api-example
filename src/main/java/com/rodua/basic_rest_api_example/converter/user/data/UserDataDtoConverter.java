package com.rodua.basic_rest_api_example.converter.user.data;

import com.rodua.basic_rest_api_example.dto.user.data.UserDataCreateRequest;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataDto;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataUpdateRequest;
import com.rodua.basic_rest_api_example.model.UserData;

public class UserDataDtoConverter {
    public UserDataDto modelToDto(UserData model) {
        return UserDataDto
                .builder()
                .userId(model.getUserId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }

    public UserData dtoToModel(UserDataDto dto) {
        return UserData
                .builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

    public UserDataDto createRequestToDto(UserDataCreateRequest request) {
        return UserDataDto
                .builder()
                .userId(request.getUserId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }

    public UserDataDto updateRequestToDto(UserDataUpdateRequest request) {
        return UserDataDto
                .builder()
                .userId(request.getUserId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
