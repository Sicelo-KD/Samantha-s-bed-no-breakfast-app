package sicelo.domain.businessRules.pricing;

import sicelo.domain.Booking;

public interface PricingPolicy {
    void price(Booking booking);
}
