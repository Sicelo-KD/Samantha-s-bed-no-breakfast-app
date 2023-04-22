package sicelo.domain.businessRules.pricing;

import sicelo.domain.Booking;
import sicelo.domain.businessRules.businessUtil.DateHelper;

public class DayBasedPricingPolicy implements PricingPolicy {
    private static final int CONSTANT = 100;
    private static final int NUMBER_OF_MONTHS_IN_A_YEAR = 12;
    private final long todayRate = (DateHelper.DAY_OF_YEAR + CONSTANT) / NUMBER_OF_MONTHS_IN_A_YEAR;

    /**
     *
     * */
    @Override
    public void price(Booking booking) {
        booking.setPrice(todayRate);
    }
}
