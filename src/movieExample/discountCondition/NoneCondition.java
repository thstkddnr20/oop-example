package movieExample.discountCondition;

import movieExample.Screening;
import movieExample.discountPolicy.NoneDiscount;

public class NoneCondition extends DiscountCondition {

    public NoneCondition() {
        super(new NoneDiscount());
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }

}
