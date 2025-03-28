package onlineLectureExample.payment.coupon;

import onlineLectureExample.payment.Money;

public class AmountCoupon extends Coupon {
    private Money amount;

    public AmountCoupon(Money amount) {
        this.amount = amount;
    }

    @Override
    public Money calculateFee(Money money) {
        return money.minus(amount);
    }
}
