package movieExample.discountPolicy;

import movieExample.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Money fee);
}
