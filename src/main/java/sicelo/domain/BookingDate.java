package sicelo.domain;

import sicelo.domain.businessRules.booking.BookingSlotPolicy;
import java.time.LocalDate;

public class BookingDate {
    private LocalDate checkInDate;
    private LocalDate checkoutDate;

    public BookingDate(LocalDate checkInDate, LocalDate checkoutDate) {
        this.checkInDate = checkInDate;
        this.checkoutDate= checkoutDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public boolean slotAvailable(BookingSlotPolicy bookingSlotPolicy){
        return bookingSlotPolicy.isSlotAvailable(checkInDate);
    }
}