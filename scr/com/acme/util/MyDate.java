package com.acme.util;

public class MyDate {

    public int day;
    public int month;
    public int year;

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
}