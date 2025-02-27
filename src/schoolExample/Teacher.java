package schoolExample;

import java.util.List;
import java.util.Map;

public class Teacher {
    private School school;
    private final Subject role;
    private Map<Day, Classroom> schedule;
    private int money;
    private int salary;

    public Teacher(Subject role, int salary) {
        this.role = role;
        this.salary = salary;
        schedule = null;
        school = null;
    }

    public void teach(Day day) {
        Classroom classroom = schedule.get(day);
        classroom.takeClass(role);
    }

    public void exam() { //시험은 모든 반이 보게된다
        List<Classroom> classrooms = school.getAllClassroom();
        for (Classroom classroom : classrooms) {
            classroom.takeExam(role);
        }
    }

    public void joinSchool(School school, Map<Day, Classroom> schedule) {
        this.school = school;
        this.schedule = schedule;
    }

    public void receiveSalary() {
        money += salary;
    }

    public Subject getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "role=" + role +
                ", schedule=" + schedule +
                ", money=" + money +
                ", salary=" + salary +
                '}';
    }
}
