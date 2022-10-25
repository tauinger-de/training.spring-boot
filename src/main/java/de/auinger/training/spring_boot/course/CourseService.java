package de.auinger.training.spring_boot.course;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {

    private final Map<String, Course> coursesMap;

    public CourseService(List<Course> courses) {
        this.coursesMap = new HashMap<>();
        courses.forEach(c -> this.coursesMap.put(c.getId(), c));
    }

    public Course getCourse(String courseId) {
        return this.coursesMap.computeIfAbsent(
                courseId,
                key -> {
                    throw new IllegalStateException();
                });
    }

    public Collection<Course> getCourses() {
        return this.coursesMap.values();
    }
}
