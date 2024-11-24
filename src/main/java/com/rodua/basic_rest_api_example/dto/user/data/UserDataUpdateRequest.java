package com.rodua.basic_rest_api_example.dto.user.data;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDataUpdateRequest {
    private Long userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}
