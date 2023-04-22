package sicelo.domain.businessRules.refund;

import sicelo.domain.Booking;

public interface RefundPolicy {
    double refund(Booking booking);
}