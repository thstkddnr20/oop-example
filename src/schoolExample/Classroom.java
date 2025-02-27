package schoolExample;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<Student> studentList;
    private static final int MAX_STUDENT = 2;

    public Classroom() {
        studentList = new ArrayList<>();
    }

    public void takeClass(Subject subject) {
        for (Student student : studentList) {
            student.study(subject);
        }
    }

    public void takeExam(Subject subject) {
        for (Student student : studentList) {
            student.takeExam(subject);
        }
    }

    public void placeStudent(Student student) {
        studentList.add(student);
    }

    public boolean isFull() {
        return studentList.size() == MAX_STUDENT;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "studentList=" + studentList +
                '}';
    }
}
