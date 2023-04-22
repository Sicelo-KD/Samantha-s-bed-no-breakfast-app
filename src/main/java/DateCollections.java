import sicelo.domain.Booking;
import sicelo.domain.Person;

import java.time.LocalDate;
import java.util.*;

public class DateCollections {
    private static final List<Booking> bookings = new ArrayList<>();
    private static final Set<Person> people = new HashSet<>();

    private static final Map<Set<Person>,List<Booking>> peopleToBookings = new HashMap<>();


    public DateCollections(){
        peopleToBookings.put(people,bookings);
    }

    public Collection<LocalDate> getBookedDates(){
        return null; //Collections.list() peopleToBookings;   //.map(booking ->
                //booking.getCheckInDate().datesUntil(booking.getCheckoutDate().plusDays(1))
        /*return bookings.stream().map((booking ->
                booking.getCheckInDate().datesUntil(booking.getCheckoutDate().plusDays(1))
                )).collect(Collectors.toUnmodifiableSet());*/
    }


    public boolean saveBooking(Booking booking){

         return bookings.add(booking);
                //peopleToBookings.get(person).add(booking);
         //}
    }

    public boolean savePerson(Person person){
       return people.add(person);
    }

    public Optional<Person> getPersonPersonByEmail(String email){
        return people.stream().filter(person -> person.getEmail().equals(email)).findFirst();
        }

    public Optional<Booking> getBookingById(String idNumber){
        return bookings.stream()
                .filter(b -> b.getPerson().getId_number().equals(idNumber)).findFirst();
    }

    public  Optional<Booking> getBookingByEmail(String email){
        return bookings.stream()
                .findFirst()
                .filter(b -> b.getPerson().getEmail().equals(email));
    }

    public void removeBooking(Booking booking){
        bookings.remove(booking);
    }

    public void clear() {
        people.clear();
        bookings.clear();
        peopleToBookings.clear();

    }
}
