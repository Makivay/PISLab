package ru.makivay.PISLab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.makivay.PISLab.model.UserDto;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserDto, UUID> {
}
