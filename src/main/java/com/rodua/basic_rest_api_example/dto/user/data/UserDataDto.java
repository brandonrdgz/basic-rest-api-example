package com.rodua.basic_rest_api_example.dto.user.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDataDto {
    private Long userId;
    private String firstName;
    private String lastName;
}
