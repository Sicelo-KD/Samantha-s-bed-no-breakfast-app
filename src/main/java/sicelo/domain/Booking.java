package sicelo.domain;

import sicelo.domain.businessRules.pricing.DayBasedPricingPolicy;
import sicelo.domain.businessRules.refund.TimeBasedRefundPolicy;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The sicelo.domain.Booking Record keeps track of person who the booking, the amount, check-it/out
 * and how many days you are going to be stating for:
 * <ul>
 *     <li>there is only one room available for booking<li/>
 *     <li>can only make 5 bookings a week<li/>
 *     <li>A week starts on monday<li/>
 *     <li>sicelo.domain.Room pricing is each day + 100/12 [10th February is the 41st day of the year
 *      e.g (41 + 100)/12 = 11,75]<li/>
 * <ul/>
 * */


public class Booking {
    private int id;
    private long amount;
    private Person person;
    private final BookingDate bookingDate;

    public Booking(Person person, long price, LocalDate checkInDate, LocalDate checkoutDate){
        this.person = person;
        this.amount = price;
        this.bookingDate = new BookingDate(checkInDate,checkoutDate);
    }

    public void applyPricingPolicy(DayBasedPricingPolicy dayBasedPricingPolicy){
        dayBasedPricingPolicy.price(this);
    }

    public void applyRefundPolicy(TimeBasedRefundPolicy timeBasedRefundPolicy){
        timeBasedRefundPolicy.refund(this);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getPrice() {
        return this.amount;
    }


    public void setPrice(long amount) {
        this.amount = amount;
    }

    public LocalDate getCheckInDate() {
        return bookingDate.getCheckInDate();
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.bookingDate.setCheckInDate(checkInDate);
    }

    public LocalDate getCheckoutDate() {
        return bookingDate.getCheckoutDate();
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.bookingDate.setCheckoutDate(checkoutDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(!Objects.isNull(this.id)){
            throw new RuntimeException("Cannot Change ID after it was Assigned");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return "sicelo.domain.Booking{" +
                "person=" + person +
                ", amount=" + amount +
                ", checkInDate=" + bookingDate.getCheckInDate() +
                ", checkoutDate=" + bookingDate.getCheckoutDate() +
                '}';
    }
}
