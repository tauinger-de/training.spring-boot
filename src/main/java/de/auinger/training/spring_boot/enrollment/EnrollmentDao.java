package de.auinger.training.spring_boot.enrollment;

import java.util.Collection;
import java.util.Optional;

public class EnrollmentDao implements EnrollmentRepository {
    @Override
    public Collection<Enrollment> findAllByCourseId(String courseId) {
        return null;
    }

    @Override
    public Optional<Enrollment> findByStudentIdAndCourseId(long studentId, String courseId) {
        return Optional.empty();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return null;
    }
}
