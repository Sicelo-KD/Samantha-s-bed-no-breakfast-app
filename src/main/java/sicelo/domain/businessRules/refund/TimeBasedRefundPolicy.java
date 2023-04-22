package sicelo.domain.businessRules.refund;

import sicelo.domain.Booking;

public class TimeBasedRefundPolicy implements RefundPolicy{


    @Override
    public double refund(Booking booking) {
        return 0;
    }
}
