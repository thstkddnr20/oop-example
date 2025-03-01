package movieExample.discountPolicy;

import movieExample.Money;

public class NoneDiscount extends DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Money fee) {
        return Money.ZERO;
    }
}
