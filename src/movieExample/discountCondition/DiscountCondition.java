package movieExample.discountCondition;

import movieExample.Money;
import movieExample.Screening;
import movieExample.discountPolicy.DiscountPolicy;

public abstract class DiscountCondition {

    private DiscountPolicy discountPolicy;

    public abstract boolean isSatisfiedBy(Screening screening);

    public Money calculateDiscountAmount(Money money) {
        return discountPolicy.calculateDiscountAmount(money);
    }

    public DiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
