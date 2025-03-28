package onlineLectureExample.payment.coupon;

import onlineLectureExample.payment.Money;

public abstract class Coupon {

    public abstract Money calculateFee(Money money);
}
