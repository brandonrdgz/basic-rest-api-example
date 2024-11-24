package com.rodua.basic_rest_api_example.service.role;

import com.rodua.basic_rest_api_example.config.exception.InvalidParamsException;
import com.rodua.basic_rest_api_example.config.exception.NotFoundException;
import com.rodua.basic_rest_api_example.converter.role.RoleDtoConverter;
import com.rodua.basic_rest_api_example.dto.role.RoleCreateRequest;
import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import com.rodua.basic_rest_api_example.repository.role.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleDtoConverter converter;

    public RoleServiceImpl(RoleRepository roleRepository, RoleDtoConverter converter) {
        this.roleRepository = roleRepository;
        this.converter = converter;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleDto create(RoleCreateRequest request) {
        try {
            roleRepository.findByName(request.getName());

            throw new InvalidParamsException("A role with the same name already exist", "");
        }
        catch (NotFoundException exception) {
        }

        final var toSave = converter.createRequestToDto(request);

        return roleRepository.save(toSave);
    }
}
