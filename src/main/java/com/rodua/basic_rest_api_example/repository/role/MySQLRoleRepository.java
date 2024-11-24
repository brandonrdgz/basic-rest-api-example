package com.rodua.basic_rest_api_example.repository.role;

import com.rodua.basic_rest_api_example.config.exception.NotFoundException;
import com.rodua.basic_rest_api_example.config.exception.PersistenceException;
import com.rodua.basic_rest_api_example.converter.role.RoleDtoConverter;
import com.rodua.basic_rest_api_example.dto.role.RoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLRoleRepository implements RoleRepository {
    private static final String ENTITY_NAME = "Role";

    private final JpaRoleRepository jpaRoleRepository;
    private final RoleDtoConverter converter;

    public MySQLRoleRepository(final JpaRoleRepository jpaRoleRepository, final RoleDtoConverter converter) {
        this.jpaRoleRepository = jpaRoleRepository;
        this.converter = converter;
    }

    @Override
    public List<RoleDto> findAll() {
        final var roles = jpaRoleRepository.findAll();

        return roles.stream().map(converter::modelToDto).toList();
    }

    @Override
    public RoleDto findById(long id) {
        final var found = jpaRoleRepository.findById(id)
                .orElseThrow(this::roleNotFoundException);

        return converter.modelToDto(found);
    }

    private NotFoundException roleNotFoundException() {
        return new NotFoundException(ENTITY_NAME + " not found", "");
    }

    @Override
    public RoleDto findByName(String name) {
        final var found = jpaRoleRepository.findByName(name)
                .orElseThrow(this::roleNotFoundException);

        return converter.modelToDto(found);
    }

    @Override
    public RoleDto save(RoleDto request) {
        final var toSave = converter.dtoToModel(request);

        try {
            final var saved = jpaRoleRepository.save(toSave);

            return converter.modelToDto(saved);
        }
        catch (Exception e) {
            throw new PersistenceException("Error to save " + ENTITY_NAME, e.getMessage());
        }
    }
}
