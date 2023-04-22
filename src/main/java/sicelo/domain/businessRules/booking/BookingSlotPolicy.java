package sicelo.domain.businessRules.booking;

import java.time.LocalDate;
import java.util.Calendar;

import sicelo.repository.BookingRepository;

import java.util.List;

public class BookingSlotPolicy {

    private static final int NUMBER_OF_BOOKABLE_DAYS_PER_WEEK = 5;
    private BookingRepository repository;

    public boolean isSlotAvailable(LocalDate date){
        List<LocalDate> bookedDates = repository.findAllBookedDates();
        int weekOfYearForDate = weekOfYear(date);
        
        var datesInWeek = bookedDates.stream()
                                .filter(bookedDate -> weekOfYear(bookedDate) == weekOfYearForDate);
        return datesInWeek.count() >= NUMBER_OF_BOOKABLE_DAYS_PER_WEEK;
    }

    
    private int weekOfYear(LocalDate date){
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, date.getYear());
        cal.set(Calendar.MONTH, date.getDayOfMonth() - 1);
        cal.set(Calendar.DAY_OF_MONTH, date.getDayOfMonth());
        return cal.getWeekYear();
    }

}

