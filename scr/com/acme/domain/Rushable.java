package com.acme.domain;

import com.acme.util.MyDate;

public interface Rushable {

    boolean isRushable(MyDate orderDate, double amount);
}
