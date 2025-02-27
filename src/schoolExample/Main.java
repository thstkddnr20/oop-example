package schoolExample;

public class Main {
    public static void main(String[] args) {
        School school = new School("강대");
        Student student = new Student("상욱");
        school.enter(student);
        Teacher mathTeacher = new Teacher(Subject.MATH, 10000);
        school.hire(mathTeacher);


        //학교란? 학생을 가르치는 장소
        //실제 가르치는건 선생이므로 학교는 선생이 가르치도록 하는것이 역할이다
        //선생님이 가르치더라도 실제로 공부 하는건(가르침을 받는건) 학생
        //즉, school.teach() -> teacher.teachStudent() -> student.study()가 된다
        school.teach(Subject.MATH);

        //공부했으니 시험봐야지
        school.doTest(Subject.MATH);

        //가르쳤으니 돈줘야지
        school.paySalary(mathTeacher);
        System.out.println(student);
        System.out.println(mathTeacher);


        /**
         * Student, Teacher은 객체의 생성을 제외하고는 사용되지않고있다
         * 모두 학교라는 요소를 통하여 접근
         */

    }
}
