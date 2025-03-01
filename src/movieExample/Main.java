package movieExample;

import movieExample.discountCondition.PeriodCondition;
import movieExample.discountCondition.SequenceCondition;
import movieExample.discountPolicy.AmountDiscount;
import movieExample.discountPolicy.PercentDiscount;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        Movie titanic = new Movie(Duration.ofHours(1), Money.wons(10000), "titanic", new SequenceCondition(1, new PercentDiscount(0.1)));
        Screening screening = new Screening(titanic, 1, LocalDateTime.now());
        Reservation reserved1 = screening.reserve(new Customer(), 3);

        Movie taken = new Movie(Duration.ofHours(2), Money.wons(12000), "taken", new PeriodCondition(DayOfWeek.SATURDAY,
                LocalTime.of(1, 0),
                LocalTime.of(15, 0),
                new AmountDiscount(Money.wons(1000))));

        LocalDateTime today = LocalDateTime.of(LocalDate.of(2025, 3, 1), LocalTime.of(2, 0));
        Screening takenScreening = new Screening(taken,
                10, today);

        Reservation reserved2 = takenScreening.reserve(new Customer(), 5);

        System.out.println(reserved1);
        System.out.println(reserved2);

    }
}
