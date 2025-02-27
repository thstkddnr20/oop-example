package schoolExample;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Student> studentList;
    private List<Teacher> teacherList;

    public School(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
    }

    public void enter(Student student) {
        studentList.add(student);
    }

    public void hire(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void teach(Subject subject) {
        Teacher teacher = getTeacherBySubject(subject);
        for (Student student : studentList) {
            teacher.teachStudent(student);
        }
    }

    public void doTest(Subject subject) {
        Teacher teacher = getTeacherBySubject(subject);
        for (Student student : studentList) {
            teacher.makeTest(student);
        }
    }

    //월급을 준다 -> 받는건 선생
    public void paySalary(Teacher teacher) {
        teacher.receive();
    }

    //과목에 맞는 올바른 선생 찾아오기
    private Teacher getTeacherBySubject(Subject subject) {
        for (Teacher teacher : teacherList) {
            if (subject == teacher.getRole()) {
                return teacher;
            }
        }
        throw new IllegalStateException("해당 과목 선생님이 없습니다");
    }
    /**
     * 학교의 역할
     * 1. 학생을 입학시킨다
     * 2. 선생님을 고용한다
     * 3. 선생님에게 월급을 준다
     */
}
