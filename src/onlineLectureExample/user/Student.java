package onlineLectureExample.user;

import onlineLectureExample.Subscription;
import onlineLectureExample.course.Course;
import onlineLectureExample.enrollment.Enrollment;
import onlineLectureExample.payment.Payment;
import onlineLectureExample.payment.coupon.Coupon;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Enrollment> enrollments;
    private List<Payment> history;
    private Subscription subscription;

    public Student(Long id, String name) {
        super(id, name);
        enrollments = new ArrayList<>();
        history = new ArrayList<>();
        subscription = Subscription.NONE;

    }

    //강의 구매
    public void purchaseCourse(Course course, Coupon coupon) {
        //자신의 enrollment에 해당 course가 있는지 확인
        for (Enrollment enrollment : enrollments) {
            if (course == enrollment.getCourse()) {
                throw new IllegalStateException("이미 수강중인 강의입니다");
            }
        }

        //payment 생성

        //enrollment 생성


    }

    //구독제에 해당하는 강의를 수강
}
