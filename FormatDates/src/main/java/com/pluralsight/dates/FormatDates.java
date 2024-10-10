package com.pluralsight.dates;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;

public class FormatDates {
    public static void main(String[] args) {
        String pattern = "MM/dd/yyyy";
        // Create class to format date
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

        LocalDate ld = LocalDate.now();
        System.out.println("Formatting date: " + ld);
        System.out.println(fmt.format(ld));
        fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(fmt.format(ld));
        fmt = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(fmt.format(ld));

        // print date and GMT time
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        DateFormat dateTime = new SimpleDateFormat("HH:mm");
//        // Change time zone to GMT
//        dateTime.setTimeZone(TimeZone.getTimeZone("GMT"));
//        String currentTime = dateTime.format(calendar.getTime());

        //Easiest way to change time zone
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        fmt = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy KK:mm");
        System.out.println(fmt.format(now));

        // Change time format
//        dateTime = new SimpleDateFormat("H:mm");
//        calendar = Calendar.getInstance(TimeZone.getTimeZone("EST"));
//        dateTime.format(calendar.getTime());
//        currentTime = dateTime.format(calendar.getTime());
        // 5:02 on 05-Sep-2021
        //System.out.println(ZoneId.getAvailableZoneIds().contains("Etc/GMT+4"));
        now = LocalDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern(now.format(DateTimeFormatter.ofPattern("H:mm")));
        fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.print(timeFmt.format(now) + " on " + fmt.format(now));
    }
}
