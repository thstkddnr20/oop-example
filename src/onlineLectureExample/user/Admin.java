package onlineLectureExample.user;

import onlineLectureExample.payment.Money;
import onlineLectureExample.payment.coupon.AmountCoupon;
import onlineLectureExample.payment.coupon.Coupon;
import onlineLectureExample.payment.coupon.PercentCoupon;

public class Admin extends User {
    public Admin(Long id, String name) {
        super(id, name);
    }

    public Coupon publishCoupon(Money amount) {
        return new AmountCoupon(amount);
    }

    public Coupon publishCoupon(double rate) {
        return new PercentCoupon(rate);
    }
}
