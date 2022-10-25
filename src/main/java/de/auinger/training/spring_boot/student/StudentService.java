package de.auinger.training.spring_boot.student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentService {

    public StudentService() {
        System.out.println("Constructing StudentService");
    }

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Fred", "Feuerstein", "Steintal"),
                new Student(2L, "Homer", "Simpson", "Springfield")
        );
    }

    public List<Student> getStudents(Predicate<Student> predicate) {
        return getStudents().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
