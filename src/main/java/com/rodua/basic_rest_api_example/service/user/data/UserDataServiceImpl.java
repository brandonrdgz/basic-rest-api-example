package com.rodua.basic_rest_api_example.service.user.data;

import com.rodua.basic_rest_api_example.config.exception.DuplicatedDataException;
import com.rodua.basic_rest_api_example.config.exception.ForbiddenException;
import com.rodua.basic_rest_api_example.config.exception.InvalidParamsException;
import com.rodua.basic_rest_api_example.config.exception.NotFoundException;
import com.rodua.basic_rest_api_example.converter.user.data.UserDataDtoConverter;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataCreateRequest;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataDto;
import com.rodua.basic_rest_api_example.dto.user.data.UserDataUpdateRequest;
import com.rodua.basic_rest_api_example.repository.user.UserRepository;
import com.rodua.basic_rest_api_example.repository.user.data.UserDataRepository;
import com.rodua.basic_rest_api_example.service.authentication.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDataService {
    private final UserDataRepository repository;
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final UserDataDtoConverter converter;

    public UserDataServiceImpl(
            UserDataRepository repository,
            UserRepository userRepository,
            AuthenticationService authenticationService,
            UserDataDtoConverter converter
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
        this.converter = converter;
    }

    @Override
    public UserDataDto findByUserId(Long userId) {
        userRepository.findById(userId);

        return repository.findByUserId(userId);
    }

    @Override
    public UserDataDto create(UserDataCreateRequest request) {
        validateUserIdIsNotNullInRequest(request.getUserId());

        try {
            findByUserId(request.getUserId());

            throw new DuplicatedDataException("User's data already exists", "");
        }
        catch (NotFoundException exception) {

        }

        final var authenticatedUser = authenticationService.authenticatedUser();
        validateModificationOrCreationOnlyOfHimself(request.getUserId(), authenticatedUser.getId());

        userRepository.findById(request.getUserId());
        final var toCreate = converter.createRequestToDto(request);

        return repository.save(toCreate);
    }

    private void validateModificationOrCreationOnlyOfHimself(Long requestUserId, Long authenticatedUserId) {
        if (! requestUserId.equals(authenticatedUserId)) {
            throw new ForbiddenException("Cannot modify or create data for another user", "");
        }
    }

    @Override
    public UserDataDto update(UserDataUpdateRequest request) {
        validateUserIdIsNotNullInRequest(request.getUserId());

        final var authenticatedUser = authenticationService.authenticatedUser();
        validateModificationOrCreationOnlyOfHimself(request.getUserId(), authenticatedUser.getId());

        userRepository.findById(request.getUserId());
        final var toUpdate = converter.updateRequestToDto(request);

        return repository.save(toUpdate);
    }

    private void validateUserIdIsNotNullInRequest(Long id) {
        if (id == null) {
            throw new InvalidParamsException("The userId must not be null", "");
        }
    }
}
