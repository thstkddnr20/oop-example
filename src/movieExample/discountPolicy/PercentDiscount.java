package movieExample.discountPolicy;

import movieExample.Money;

public class PercentDiscount extends DiscountPolicy {
    private double percent;

    @Override
    public Money calculateDiscountAmount(Money fee) {
        return fee.times(percent);
    }

    public PercentDiscount(double percent) {
        this.percent = percent;
    }
}
