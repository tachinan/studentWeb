
import java.util.ArrayList;
import java.util.List;

public class StudentTable {
    private static List<Student> students = new ArrayList<>();

    public static boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return false; // Duplicate ID
            }
        }
        students.add(student);
        return true; // Successful addition
    }

    public static List<Student> getAllStudents() {
        return students;
    }
}
