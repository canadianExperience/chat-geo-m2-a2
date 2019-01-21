package com.zv.geochat.Util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utility {




    //Convert Date from iso format to local
    public static String isoDateToLocal(String isoDate) {

        final String inputDateAsString = isoDate;
        final String inputStringFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        final DateFormat iso8601DateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        iso8601DateFormatter.setTimeZone(TimeZone.getTimeZone("EST"));

        final DateFormat inputDateFormatter = new SimpleDateFormat(inputStringFormat, Locale.ENGLISH);
        inputDateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date inputDate = new Date();
        try {
            inputDate = inputDateFormatter.parse(inputDateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result = iso8601DateFormatter.format(inputDate);

        return result;
    }

    //Convert Date to iso String
    public static String dateToISOString(Date dt) {
        final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getDefault());
        String text = sdf.format(dt);
        return text;
    }

    //Convert Date to String
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDt = simpleDate.format(date);
        return strDt;
    }

    //Convert isoString format to Date
    public static Date isoStringToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = format.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    //Convert isoString format to Date Time String
    public static String isoStringToDateTime(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date date = format.parse(str);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String reportDate = df.format(date);
            return reportDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    //Concert date string in "yyyy-MM-dd" format to iso
    public static String dateStringToIso(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dateStr);
            String isoStr = dateToISOString(date);
            return isoStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return dateToISOString(new Date());
        }
    }
}

