package ru.makivay.PISLab.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.makivay.PISLab.api.UserNotFoundException;
import ru.makivay.PISLab.model.User;
import ru.makivay.PISLab.model.UserDto;
import ru.makivay.PISLab.service.UserMapper;
import ru.makivay.PISLab.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("")
    public Iterable<UserDto> readAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto readById(@PathVariable("id") final String id) {
        return userService.find(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("")
    public UserDto create(@Valid @RequestBody User user) {
        final UserDto userDto = userMapper.map(user);
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") String id, @Valid @RequestBody User user) {
        final UserDto userDto = userService.find(id).orElseThrow(() -> new UserNotFoundException(id));
        return userService.save(userMapper.update(userDto, user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.find(id).ifPresent(userService::delete);
    }
}
