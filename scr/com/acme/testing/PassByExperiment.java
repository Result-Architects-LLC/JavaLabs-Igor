package com.acme.testing;

import com.acme.util.MyDate;

public class PassByExperiment {

    public static void passPrimitive (int i) {
        i = 2029;
    }

    public static void passString (String s) {
        int yearSlash = s.lastIndexOf('/');
        s = s.substring(0, yearSlash+1);
        s +="2039";
        System.out.println("New date string: " + s);
    }
}
