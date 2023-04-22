package sicelo.repository;

import sicelo.domain.Booking;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingRepository {

    private static final BookingRepository INSTANCE = new BookingRepository();
    private final Map<Integer , Booking> bookingsById;
    private final Map<Integer, List<Booking>> bookingsByPersonId;

    private AtomicInteger lastId;


    private BookingRepository() {
        super();
        this.bookingsById = new LinkedHashMap<Integer, Booking>();
        this.bookingsByPersonId = new LinkedHashMap<Integer, List<Booking>>();
        this.lastId = new AtomicInteger(0);
    }

    public List<Booking> findAll(){
        return new ArrayList<>(this.bookingsById.values());
    }

    public void save(Booking booking){
        insert(booking);
        bookingsById.put(booking.getId(), booking);
    }

    public void insert(Booking booking){
        booking.setId(lastId.incrementAndGet());
    }

    public void delete(int id){
        if(this.bookingsById.containsKey(id)){
            this.bookingsById.remove(id);
        }
        else{
            throw new RuntimeException("ID Does Not Exist");
        }
    }

    public void update(int id, Booking newBooking){
        //fixme should use alternative method besides replace to ensure that id is NOT replaced
        this.bookingsById.replace(id, newBooking);
    }

    public Booking findById(final int id){
        return this.bookingsById.get(id);
    }

    public Optional<Booking> findByPersonalIdNumber(String idNumber){
        return this.bookingsById.values()
                .stream()
                .filter(b -> b.getPerson().getId_number().equals(idNumber))
                .findFirst();
    }

    public Optional <Booking> findByEmail(String email){
        return this.bookingsById.values()
                .stream()
                .findFirst()
                .filter(b -> b.getPerson().getEmail().equals(email));
    }

    public List<Booking> findBookingsForPerson(final int id){
        return this.bookingsByPersonId.get(id);
    }

    public void updateBookingForPerson(int id, Booking newBooking){
        // FIXME: 2023/04/22 
    }

    public List<LocalDate> findAllBookedDates(){
        var dates = new ArrayList<LocalDate>();
        this.findAll().
                forEach(b -> dates.add(b.getCheckInDate()));
        return dates;
    }

    public long count(){
        return this.bookingsById.values().size();
    }

    public static BookingRepository getInstance() {
        return INSTANCE;
    }

}
