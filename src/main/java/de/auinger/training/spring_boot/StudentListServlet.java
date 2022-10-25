package de.auinger.training.spring_boot;

import de.auinger.training.spring_boot.student.Student;
import de.auinger.training.spring_boot.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StudentService studentService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var students = studentService.getStudents();

        response.setContentType("text/plain");
        for (Student student : students) {
            var studentRepresentation = String.format("#%d: %s, %s", student.getId(), student.getLastName(), student.getFirstName());
            response.getWriter().println(studentRepresentation);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        var servletContext = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        ctx.getAutowireCapableBeanFactory().autowireBean(this);
    }
}
