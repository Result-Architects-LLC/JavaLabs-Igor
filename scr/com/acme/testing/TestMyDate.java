package com.acme.testing;
import com.acme.util.MyDate;

public class TestMyDate{
    public TestMyDate() {
    }

    public static void main(String[] args){
        MyDate date1 = new MyDate(11,11,1918);

        MyDate date2 = new MyDate(11,11,1918);

        MyDate date3 = new MyDate();
        date3.setDate(4,21,1968);

        System.out.println("Date 1 " + date1);
        System.out.println("Date 2 " + date2);
        System.out.println("Date 3 " + date3);

        MyDate calendarStart = new MyDate(1, 1, 2019);
        MyDate fiscalStart =  new MyDate(1, 7, 2019);

        if(calendarStart.equals(fiscalStart)){
            System.out.println("calendarStart equals fiscalStart");
        }
        else {
            System.out.println("calendarStart does not equal fiscalStart");
        }
        MyDate.printHolidays();
        }
//        MyDate.printLeapYears();

    }
