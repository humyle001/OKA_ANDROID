package oka.codedieux.com.restaurant.operations;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOperations {

    public static boolean isInDateLimit(String startDateString, String endDateString){
        boolean result=false;
        Format formatter = new SimpleDateFormat("EEEE dd MMMM yyyy - HH:mm");
        String s = formatter.format(new Date());
        try {
            Date currentDate = (Date)formatter.parseObject(s);
            Date startDate= (Date)formatter.parseObject(startDateString);
            Date endDate= (Date)formatter.parseObject(endDateString);
            if(currentDate.after(startDate) && currentDate.before(endDate)) {
                result =true;
            }
        } catch (ParseException e) {

        }
        return result;
    }

    public  static String getCurrentDate(){
        Format formatter = new SimpleDateFormat("EEEE dd MMMM yyyy - HH:mm");
        String s = formatter.format(new Date());
        return s;
    }

}
