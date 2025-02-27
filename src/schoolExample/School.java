package schoolExample;

import java.util.*;

public class School {
    private String name;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Classroom> classrooms;
    private static final int MAX_CLASSROOM = 5;

    public School(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        for (int i = 0; i < MAX_CLASSROOM; i++) {
            classrooms.add(new Classroom());
        }
    }

    public void enter(Student student) {
        studentList.add(student);
        for (Classroom classroom : classrooms) {
            if (!classroom.isFull()) {
                classroom.placeStudent(student);
                break;
            }
        }
    }

    public void hire(Teacher teacher) {
        teacherList.add(teacher);
        teacher.joinSchool(this, makeSchedule());
    }

    //월급을 준다 -> 받는건 선생
    public void paySalary(Teacher teacher) {
        teacher.receiveSalary();
    }

    public List<Classroom> getAllClassroom() {
        return classrooms;
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

    //선생을 고용할때 스케줄을 만들어 주기
    private Map<Day, Classroom> makeSchedule() {
        Map<Day, Classroom> schedule = new HashMap<>();
        List<Classroom> shuffled = new ArrayList<>(classrooms);

        Collections.shuffle(shuffled, new Random());

        Day[] days = {Day.MON, Day.TUE, Day.WED, Day.THU, Day.FRI};
        for (int i = 0; i < days.length; i++) {
            schedule.put(days[i], shuffled.get(i));
        }
        return schedule;
    }
    /**
     * 학교의 역할
     * 1. 학생을 입학시킨다
     * 2. 선생님을 고용한다
     * 3. 선생님에게 월급을 준다
     */
}
