package de.auinger.training.spring_boot;

import de.auinger.training.spring_boot.student.Student;
import de.auinger.training.spring_boot.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/students")
public class AnnotatedServlet extends HttpServlet {

    @Autowired
    StudentService studentService;

    public AnnotatedServlet() {
        System.out.println("Constructing AnnotatedServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var students = studentService.getStudents();
        System.out.println(getClass().getSimpleName() + ": doGet()");

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
        AutowireCapableBeanFactory beanFactory = ((ApplicationContext) servletContext.getAttribute(
                "applicationContext")).getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }
}
