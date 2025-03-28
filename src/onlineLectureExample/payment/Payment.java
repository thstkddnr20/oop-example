package onlineLectureExample.payment;

import onlineLectureExample.course.Course;
import onlineLectureExample.payment.coupon.Coupon;
import onlineLectureExample.user.Student;

public class Payment {

    private Course course;

    private Money price; //쿠폰 적용에 따라 가격이 달라질 수 있음
    private Coupon coupon;

    private Student student;
    private PaymentStatus status;

    public static Payment of(Course course, Coupon coupon, Student student) {
        Payment payment = new Payment();
        payment.course = course;
        if (coupon != null) {
            payment.price = coupon.calculateFee(course.getPrice());
        }
        else {
            payment.price = course.getPrice();
        }
        payment.student = student;
        payment.status = PaymentStatus.SUCCESS;
        return payment;
    }

    @Override
    public String toString() {
        return "결제 금액: " + price;
    }
}
