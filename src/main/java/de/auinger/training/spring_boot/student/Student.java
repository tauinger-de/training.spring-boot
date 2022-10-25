package de.auinger.training.spring_boot.student;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {

    private long id;
    private String firstName;
    private String lastName;

}
