package onlineLectureExample.payment.coupon;

import onlineLectureExample.payment.Money;

public class PercentCoupon extends Coupon {

    private double rate;

    public PercentCoupon(double rate) {
        this.rate = rate;
    }

    @Override
    public Money calculateFee(Money money) {
        return money.times(rate);
    }
}
