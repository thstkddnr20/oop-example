package onlineLectureExample.user;

import onlineLectureExample.Subscription;
import onlineLectureExample.course.Course;
import onlineLectureExample.course.CourseStatus;
import onlineLectureExample.enrollment.Enrollment;
import onlineLectureExample.payment.Payment;
import onlineLectureExample.payment.coupon.Coupon;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Enrollment> enrollments;
    private List<Payment> payments;
    private Subscription subscription;

    public Student(Long id, String name) {
        super(id, name);
        enrollments = new ArrayList<>();
        payments = new ArrayList<>();
        subscription = Subscription.NONE;

    }

    //강의 구매
    public Payment enroll(Course course, Coupon coupon) {
        if (course.getCourseStatus() != CourseStatus.PUBLISHED) {
            throw new IllegalStateException("수강할 수 있는 과목이 아닙니다");
        }

        //자신의 enrollment에 해당 course가 있는지 확인
        for (Enrollment enrollment : enrollments) {
            if (course.equals(enrollment.getCourse())) {
                throw new IllegalStateException("이미 수강중인 강의입니다");
            }
        }

        //payment 생성
        Payment payment = Payment.of(course, coupon, this);
        payments.add(payment);

        //enrollment 생성
        Enrollment enrollment = Enrollment.of(course);
        enrollments.add(enrollment);

        return payment;
    }

    //구독제에 해당하는 강의를 수강
}
