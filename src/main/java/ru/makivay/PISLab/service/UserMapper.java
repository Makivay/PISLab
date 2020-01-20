package ru.makivay.PISLab.service;

import org.springframework.stereotype.Service;
import ru.makivay.PISLab.model.User;
import ru.makivay.PISLab.model.UserDto;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserMapper {
    public UserDto map(final String id, final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(UUID.fromString(id));
        update(userDto, user);
        return userDto;
    }

    public UserDto map(final User user) {
        final UserDto userDto = new UserDto();
        update(userDto, user);
        return userDto;
    }

    public UserDto update(final UserDto userDto, final User user) {
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }

    public User map(final UserDto userDto) {
        final User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    public Iterable<User> map(final Iterable<UserDto> userDtos) {
        return StreamSupport
                .stream(userDtos.spliterator(), false)
                .map(this::map)
                .collect(Collectors.toList());
    }
}
