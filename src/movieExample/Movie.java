package movieExample;

import movieExample.discountCondition.DiscountCondition;
import movieExample.discountCondition.NoneCondition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(Duration runningTime, Money fee, String title, DiscountCondition... discountCondition) {
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountCondition);
        this.title = title;
    }

    public Money calculateMovieFee(Screening screening) {
        DiscountCondition condition = getAvailableDiscountCondition(screening);
        return fee.minus(calculateDiscountAmount(condition));
    }

    public Money calculateDiscountAmount(DiscountCondition discountCondition) {
        return discountCondition.calculateDiscountAmount(fee);
    }

    private DiscountCondition getAvailableDiscountCondition(Screening screening) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.isSatisfiedBy(screening)) {
                return discountCondition;
            }
        }
        return new NoneCondition();
    }
}
