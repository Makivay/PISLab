package ru.makivay.PISLab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makivay.PISLab.model.UserDto;
import ru.makivay.PISLab.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public Iterable<UserDto> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<UserDto> find(final String idAsString) {
        final UUID id = UUID.fromString(idAsString);
        return userRepository.findById(id);
    }

    @Transactional
    public UserDto save(final UserDto user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(final UserDto user) {
        userRepository.delete(user);
    }


}
