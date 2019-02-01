package com.zv.geochat.Util;


import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utility {

    //Convert Date to String
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDt = simpleDate.format(date);
        return strDt;
    }

    //Convert String format to Date
    public static Date stringToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    //Convert Date to time ago (PrettyTime) format
    public static String dateToPrettyTime(Date date)
    {
        PrettyTime p = new PrettyTime();
        String ptDate = p.format(date);

        return ptDate;
    }

}
