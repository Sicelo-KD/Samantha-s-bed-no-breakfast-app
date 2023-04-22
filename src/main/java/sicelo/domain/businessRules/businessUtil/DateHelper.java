package sicelo.domain.businessRules.businessUtil;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import sicelo.domain.Booking;

public class DateHelper {
    /**
     * 1 day == 24 hours...
     * per day, from 13th day until 7 days before booking date, the rate is 7, 142 857 143%
     * per day, from 7th day until booking to the rate is 10%
     *
     * per day, from 13th day before booking date, the rate is 7, 6923 076 92%
     * how ever, from the 2nd before booking date we can't allow refund "not refundable"
     *
     * per day, from 13th day before booking date to 2 days before which makes 12 days, the rate is 8.3333333333%
     * that's on 7th day it will cost the user 50% to cancel / reschedule
     *
     */


    public static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final ZoneId zoneId = ZoneId.of("SAR");
    public static final LocalDate TODAYS_DATE = LocalDate.parse(LocalDate.now(zoneId).format(DD_MM_YYYY));
    public static final int DAY_OF_YEAR =  TODAYS_DATE.getDayOfYear();
    public static final int WEEK_OF_YEAR = Calendar.WEEK_OF_YEAR;


    public LocalDate getBooking(Booking b){
        return b.getCheckInDate();
    }

    public LocalDate getWeekNumber(LocalDate date){
        String StringDate = date.toString();
        return null;
    }
    //public int getDAY_OF_YEAR(Date date) {
     //   return DAY_OF_YEAR;
    //}

    /*public int numberOfDaysBeforeCheckIn(Calendar date){
        return Calendar.getInstance().getTime().compareTo(date.getTime());
    }

    public LocalDate getTODAYS_DATE() {
        return TODAYS_DATE;
    }*/
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        //System.out.println(date.format(DD_MM_YYYY).toString());
        String[] var1 = date.format(DD_MM_YYYY).toString().split("/");
        var monthV = date.getMonthValue();
        var dateV = date.getDayOfMonth();

        //Calendar cal = Calendar.getInstance().setTime();
        //cal.set(2023,Calendar.MARCH,dateV);

        //System.out.println(cal.WEEK_OF_YEAR);
    }



}
