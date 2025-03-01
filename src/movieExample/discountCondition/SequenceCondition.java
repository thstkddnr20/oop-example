package movieExample.discountCondition;

import movieExample.Screening;
import movieExample.discountPolicy.DiscountPolicy;

public class SequenceCondition extends DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence, DiscountPolicy discountPolicy) {
        super(discountPolicy);
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
