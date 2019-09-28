package com.acme.testing;

import com.acme.util.MyDate;

public class TestPassByExperiment {

    public static void main(String[] args) {
        System.out.println("Test passing an object");

        {
            MyDate dateUsedForTesting = new MyDate(1, 12, 2008);
            System.out.println(dateUsedForTesting);
            dateUsedForTesting.printMyDate();
            PassByExperiment.passObject(dateUsedForTesting);
            System.out.println(dateUsedForTesting);
            dateUsedForTesting.printMyDate();

            System.out.println("Test passing an primitive - year");
            dateUsedForTesting.printMyDate();
            PassByExperiment.passPrimitive(dateUsedForTesting.year);
            dateUsedForTesting.printMyDate();

            System.out.println("Test passing a string");
            dateUsedForTesting.printMyDate();
            String x = dateUsedForTesting.toString();
            System.out.println("Date in text format before 2: "+x);
            PassByExperiment.passString(x);
            System.out.println("Date in text format after: "+x);
        }


    }
}
