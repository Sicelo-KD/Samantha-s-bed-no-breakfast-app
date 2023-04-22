import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;



public class CalendarUtil {
    static Builder builder;

    static int MINIMUM_BOOKABLE_DAYS_PER_WEEK = 5;

    public static Calendar calendarFor(final int year, final int month, final int day,
                                       final int hour, final int minute) {

        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }


    private CalendarUtil() {
        super();
    }


    public void resolveTimeZone(){
    }

    public int getDayOfyear(){
        return 76;
    }
    public void getDateFormat(){}
    public Date getTodaysDate(){
        return Calendar.getInstance().getTime();
    };
    public boolean datesInSafeRange(Date d1, Date d2){
        return false;
    }
    public void getWeekNumber(){}




    public static void main(String[] args) {
        Calendar cal = calendarFor(2023,3,17,16,31);

        System.out.println(cal.getCalendarType());
        System.out.println(cal.getTimeZone());
        System.out.println(cal.getTime());
        System.out.println( "First day of week ==>" + cal.getFirstDayOfWeek());
        System.out.println(cal.getWeekYear());
        System.out.println();
        HttpRequest.Builder req = HttpRequest.newBuilder();
        HttpClient client = HttpClient.newHttpClient();
        HttpClient clientel = HttpClient.newHttpClient();




    }
}


