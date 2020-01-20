package ru.makivay.PISLab.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
}
