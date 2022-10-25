package de.auinger.training.spring_boot.student;

import java.util.List;

public class StudentService {

    public StudentService() {
        System.out.println("Constructing StudentService");
    }

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Fred", "Feuerstein")
        );
    }
}
