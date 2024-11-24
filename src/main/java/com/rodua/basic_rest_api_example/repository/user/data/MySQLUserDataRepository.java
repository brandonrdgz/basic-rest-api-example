package com.rodua.basic_rest_api_example.repository.user.data;

import com.rodua.basic_rest_api_example.config.exception.NotFoundException;
import com.rodua.basic_rest_api_example.config.exception.PersistenceException;
import com.rodua.basic_rest_api_example.converter.user.data.UserDataDtoConverter;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataDto;
import org.springframework.stereotype.Repository;

@Repository
public class MySQLUserDataRepository implements UserDataRepository {
    private static final String ENTITY_NAME = "User Data";

    private final JpaUserDataRepository jpaUserDataRepository;
    private final UserDataDtoConverter converter;

    public MySQLUserDataRepository(JpaUserDataRepository jpaUserDataRepository, UserDataDtoConverter converter) {
        this.jpaUserDataRepository = jpaUserDataRepository;
        this.converter = converter;
    }

    @Override
    public UserDataDto findByUserId(Long userId) {
        final var found = jpaUserDataRepository.findByUserId(userId)
                .orElseThrow(this::userDataNotFoundException);

        return converter.modelToDto(found);
    }

    private NotFoundException userDataNotFoundException() {
        return new NotFoundException(ENTITY_NAME + " not found", "");
    }

    @Override
    public UserDataDto save(UserDataDto dto) {
        final var toSave = converter.dtoToModel(dto);

        try {
            final var saved = jpaUserDataRepository.save(toSave);

            return converter.modelToDto(saved);
        }
        catch (Exception exception) {
            throw new PersistenceException("Error to save " + ENTITY_NAME, exception.getMessage());
        }
    }

    @Override
    public void deleteByUserId(Long userId) {
        try {
            jpaUserDataRepository.deleteByUserId(userId);
        }
        catch (Exception exception) {
            throw new PersistenceException("Error deleting " + ENTITY_NAME, exception.getMessage());
        }
    }
}
