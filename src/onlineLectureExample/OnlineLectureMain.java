package onlineLectureExample;

import onlineLectureExample.course.*;
import onlineLectureExample.payment.Money;
import onlineLectureExample.payment.Payment;
import onlineLectureExample.payment.coupon.Coupon;
import onlineLectureExample.user.Admin;
import onlineLectureExample.user.Instructor;
import onlineLectureExample.user.Student;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OnlineLectureMain {
    public static void main(String[] args) {
        Student student = new Student(1L, "상욱");

        Instructor instructor = new Instructor(2L, "쓰앵님");

        //일반 강의
        Course course1 = instructor.makeCourse("강의1", Category.DESIGN, Difficulty.EASY, Money.wons(20000));
        System.out.println(course1);

        //강의는 생성 시 선행조건이 없고 -> 섹션을 생성하기 위해서는 강의영상이 적어도 1개 있어야 하고 -> 강의의 게시를 위해서는 최소 1개 이상의 섹션을 포함 해야함.
        Lecture lecture1 = instructor.makeLecture(3L, "디자인의 기초1", Duration.ofMinutes(30), "첨부자료");
        Section section1 = instructor.makeSection(4L, course1, "디자인 기초 시작", 1, Arrays.asList(lecture1));
        //sectionNum이 중복되면 이미 만들어진 섹션은 어떻게 할것인가?
        //-> 생성 부터 course를 인자로 전달하여 코스의 섹션 리스트 검토

        //course에 section 추가할 때도 추가 섹션 번호 검토
        course1.addSection(section1);
        course1.post();

        List<Course> posted = instructor.getPostedCourses();
        System.out.println(posted);

        Admin admin = new Admin(5L, "관리자");
        Coupon tenThousandCoupon = admin.publishCoupon(Money.wons(10000));
        Payment payment = student.enroll(course1, tenThousandCoupon);
        System.out.println("payment = " + payment);


    }
}
