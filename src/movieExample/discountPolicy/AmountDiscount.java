package movieExample.discountPolicy;

import movieExample.Money;

public class AmountDiscount implements DiscountPolicy {
    private Money discountAmount;

    @Override
    public Money calculateDiscountAmount(Money fee) {
        return discountAmount;
    }

    public AmountDiscount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }
}
