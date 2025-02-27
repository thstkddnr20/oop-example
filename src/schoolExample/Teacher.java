package schoolExample;

public class Teacher {
    private final Subject role;
    private int money;
    private int salary;

    public Teacher(Subject role, int salary) {
        this.role = role;
        this.salary = salary;
    }

    //선생의 역할 1. 학생을 가르치다
    //가르치는건 선생이지만, 공부는 학생이 한다
    public void teachStudent(Student student) {
        student.study(role);
    }

    //선생의 역할 2. 시험을 치르도록한다
    //시험을 봐야하는건 학생
    public void makeTest(Student student) {
        student.takeTest(role);
    }

    public void receive() {
        money += salary;
    }

    public Subject getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "role=" + role +
                ", money=" + money +
                '}';
    }
}
