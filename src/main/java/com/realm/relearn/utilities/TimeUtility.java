package com.realm.relearn.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtility {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    public Date getCreationDateConverted(String timeZone, String time) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return dateFormat.parse(time);
    }

    public void setCreationDate(Date date, String timeZone, String time){
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        time = dateFormat.format(date);
    }
}
