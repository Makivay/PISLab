package ru.makivay.PISLab.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
}
