package de.auinger.training.spring_boot;

import de.auinger.training.spring_boot.course.Course;
import de.auinger.training.spring_boot.course.CourseService;
import de.auinger.training.spring_boot.enrollment.Enrollment;
import de.auinger.training.spring_boot.enrollment.EnrollmentService;
import de.auinger.training.spring_boot.student.Student;
import de.auinger.training.spring_boot.student.StudentService;
import lombok.Setter;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/students")
public class StudentListServlet extends HttpServlet {

    @Setter
    private StudentService studentService;

    @Setter
    private CourseService courseService;

    @Setter
    private EnrollmentService enrollmentService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/plain");

            response.getWriter().println("STUDENTS:");
            for (Student student : studentService.getStudents()) {
                var repr = String.format("  #%d: %s, %s", student.getId(), student.getLastName(), student.getFirstName());
                response.getWriter().println(repr);
            }

            response.getWriter().println("\nCOURSES:");
            for (Course c : courseService.getCourses()) {
                var repr = String.format("  %s: %s (max=%d)", c.getId(), c.getTitle(), c.getMaxEnrollments());
                response.getWriter().println(repr);

                for (Enrollment e : enrollmentService.getEnrollments(c.getId())) {
                    repr = String.format("    studentId %d", e.getStudentId());
                    response.getWriter().println(repr);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();

        // since this servlet has been created by Tomcat, not by Spring it hasn't been subject
        // to any CDI processing -- which is what we are doing now by hand
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        ctx.getAutowireCapableBeanFactory().autowireBeanProperties(
                this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,
                true);
    }
}
