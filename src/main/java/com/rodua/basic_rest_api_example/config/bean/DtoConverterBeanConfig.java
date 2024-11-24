package com.rodua.basic_rest_api_example.config.bean;

import com.rodua.basic_rest_api_example.converter.role.RoleDtoConverter;
import com.rodua.basic_rest_api_example.converter.user.UserDtoConverter;
import com.rodua.basic_rest_api_example.converter.user.data.UserDataDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConverterBeanConfig {
    @Bean
    public UserDtoConverter userDtoConverter() {
        return new UserDtoConverter();
    }

    @Bean
    public UserDataDtoConverter userDataDtoConverter() {
        return new UserDataDtoConverter();
    }

    @Bean
    public RoleDtoConverter roleDtoConverter() {
        return new RoleDtoConverter();
    }
}
