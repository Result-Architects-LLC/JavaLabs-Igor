package com.acme.util;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class MyDate {

    private int day;
    private int month;
    private int year;

    private static MyDate [] holidays;

    public MyDate(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate() {
//        this is a no-argument constructor; it does not make sense to me but TestMyDate requires it
    }

    public void setDate(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static void printLeapYears() {
        for (int x = 1752; x <= 2020; x = x + 4) {
            if ((x % 100 != 0) || (x % 400 == 0)) {
                System.out.println("Year: " + x);

            }
        }
    }
    public void  printMyDate () {
        System.out.println("Day: "+ day + " Month: " + month + " Year: " + year);
    }

    public long daysBetweenTodayAndMyDate() {
        // this method returns the number of days between LocalDate.now and MyDate that it implicitly receives as a parameter
        LocalDate orderDate = LocalDate.of(this.year, this.month, this.day);
        return DAYS.between(orderDate,LocalDate.now());
    }

    public String toString() {
        return ("Year " + year + " Month " + month + " Day " + day);
    }

    public static boolean isHoliday(MyDate proposedDate) {
        for (MyDate holiday : holidays)
        {if (proposedDate.equals(holiday)) return true;}
            return false;
    }

    static {
        holidays = new MyDate[6];
        holidays[0] = new MyDate(1, 1, 2016);
        holidays[1]= new MyDate(5,9,2016);
        holidays[2] = new MyDate(30, 5, 2016);
        holidays[3] = new MyDate(24, 11,2016);
        holidays[4] = new MyDate(4, 7, 2016);
        holidays[5] = new MyDate(25, 12, 2016);
    }

    public static void printHolidays () {
        System.out.println("The company holidays are:");
        for (MyDate holiday : holidays) holiday.printMyDate();
    }

    public boolean equals (Object o) {
    if (o instanceof MyDate) {
        MyDate d = (MyDate) o;
        if ((d.day == day) && (d.month == month) && (d.year == year)) {
            return true;}
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}