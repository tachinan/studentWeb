import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("students", StudentTable.getAllStudents());
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double gpa = Double.parseDouble(request.getParameter("gpa"));

            if (id <= 0) {
                request.setAttribute("errorMessage", "ID must be a positive number.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            if (gpa < 0.0 || gpa > 4.0) {
                request.setAttribute("errorMessage", "GPA must be between 0.0 and 4.0.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            // Create a new Student object
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setGpa(gpa);

            // Attempt to add the student to the StudentTable
            if (!StudentTable.addStudent(student)) {
                request.setAttribute("errorMessage", "Student with this ID already exists.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("addedStudent", student);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid ID or GPA format. Please enter valid numbers.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling student information.";
    }
}
