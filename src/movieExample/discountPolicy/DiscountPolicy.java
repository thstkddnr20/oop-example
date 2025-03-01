package movieExample.discountPolicy;

import movieExample.Money;

public abstract class DiscountPolicy {
    public abstract Money calculateDiscountAmount(Money fee);
}
