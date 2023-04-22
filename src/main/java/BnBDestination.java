import sicelo.domain.Booking;
import sicelo.domain.Person;
import sicelo.domain.businessRules.businessUtil.DateHelper;
import sicelo.domain.businessRules.businessUtil.MoneyHelper;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Optional;

public class BnBDestination {
    static DateCollections dbase = new DateCollections();
    static DateHelper dateHelper = new DateHelper();

    public static void main(String[] args) {
        seedDemoData();
        System.out.println("=======Bookings By Emails======");
        System.out.println(dbase.getBookingById("9302225626085"));
        System.out.println(dbase.getBookingById("9705263426089"));
        System.out.println(dbase.getBookingById("9109252157084") + "\n");

        System.out.println("======People by Email======");
        System.out.println(dbase.getPersonPersonByEmail("ssntombana93@gmail.com"));
        System.out.println(dbase.getPersonPersonByEmail("ndlela@gmail.com"));
        System.out.println(dbase.getPersonPersonByEmail("mpilohealthy@gmail.com") + "\n");
        System.out.println();
        dbase.clear();
    }

    public static void createProfile(String[] personDetails){

        dbase.savePerson(new Person(personDetails[0],
                personDetails[1],personDetails[2],
                personDetails[3],personDetails[4]));
    }

    public static void login(Person person){
        // FIXME: 2023/03/21 Implement me!!!
        throw new RuntimeException("Not yet implemented");
    }

    public static void book(Booking b){
        if(isWeekAvailableForBooking()){
            dbase.saveBooking(b);
        } else{
            throw new RuntimeException("Week is fully Booked");
        }
    }

    public static Optional<Booking> getBooking(String email){
        return dbase.getBookingByEmail(email);
    }

    public static Calendar getCalendar(){
        return null;
    }

   // public static sicelo.domain.Booking getBooking(sicelo.domain.Person person){
   //     return null;
    //}

    public static void cancelBooking(){
    }

    public static void rescheduleBooking(){}

    private static boolean isWeekAvailableForBooking(){
        // FIXME: 2023/03/21 mocked!!
        return true;}
    private static void seedDemoData(){

        /** A sicelo.domain.Person goes to their browser and searches for our
         * app to book a room 10 days from today.
         * he inputs all necessary details
         * proceeds to open the booking form and proceeds to fill in details
         * - checking 10 days from today, and checking out the day after
         * */

        String[] siceloDetails = {"Sicelo", "Ntombana", "9302225626085", "ssntombana93@gmail.com", "0684791743"};
        String[] amandaDetails = {"Amanda", "Ndlela", "9705263426089", "ndlela@gmail.com", "07347917443"};
        String[] mpiloDetails = {"Mpilo", "Ntombana", "9109252157084", "mpilohealthy@gmail.com", "0828191478"};


        /**Can the System save the sicelo.domain.Person's Details?
         * */
        createProfile(siceloDetails);
        createProfile(amandaDetails);
        createProfile(mpiloDetails);

        /**
         * Sicelo makes a booking 20 days before checking in / booking-date
         * */

        Person siceloMakingBooking = dbase.getPersonPersonByEmail(siceloDetails[3])
                .orElseThrow(() -> new BaseExceptions("Email Not Found"));

        Person amandaMakingBooking = dbase.getPersonPersonByEmail(amandaDetails[3])
                .orElseThrow(() -> new BaseExceptions("Email Not Found"));

        Person mpiloMakingBooking = dbase.getPersonPersonByEmail(mpiloDetails[3])
                .orElseThrow(() -> new BaseExceptions("Email Not Found"));

        /** Sicelo Details */
        LocalDate bookingDate = LocalDate.now().minusDays(20);
        LocalDate checkOutDate = bookingDate.plusDays(1);

        /**Amanda Details... */
        LocalDate aBookingDate = LocalDate.now().minusDays(13);
        LocalDate aCheckOutDate = aBookingDate.plusDays(1);

        /**Mpilo Details */
        LocalDate mBookingDate = LocalDate.now().minusDays(6);
        LocalDate mCheckOutDate = mBookingDate.plusDays(1);

        Booking siceloBooking =  new Booking(siceloMakingBooking,
                MoneyHelper.getIntAmount(),
                bookingDate,
                checkOutDate
                );

        Booking amandaBooking =  new Booking(amandaMakingBooking,
                MoneyHelper.getIntAmount(),
                aBookingDate,
                aCheckOutDate
        );

        Booking mpiloBooking =  new Booking(mpiloMakingBooking,
                MoneyHelper.getIntAmount(),
                mBookingDate,
                mCheckOutDate
        );


        /**  System saves the details... */
        dbase.saveBooking(siceloBooking);
        dbase.saveBooking(amandaBooking);
        dbase.saveBooking(mpiloBooking);
    }

}
