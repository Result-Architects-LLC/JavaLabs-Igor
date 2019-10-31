package com.acme.testing;

import com.acme.domain.*;
import com.acme.util.MyDate;

public class TestOrders {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyDate date1 = new MyDate(1,20,2008);
        Solid anvil = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 5000, 0.5, 0.5);
        Order anvilOrder = new Order(date1, 2.00, "Wile E Coyote",anvil, 10);
        anvilOrder.printOrderObject();

        // on the next line I get product from the order and then cast it as Solid so that I can use getLength method. This is an extra credit problem that demonstrates that casting may be necessary when working with inheritance and polymorphism

        if(anvilOrder.getProduct() instanceof Solid) {
            System.out.println("Length: " + ((Solid) anvilOrder.getProduct()).getLength());
        }
        // on the next line I simply call getLength because I have anvil reference variable available in my code. This is a simpler alternative to the above code.  However, often you would not have a reference variable of the right type available and then casting would be required.

        System.out.println("Length: "+ anvil.getLength());
        System.out.println("Volume: " + anvil.calculateVolume());


        MyDate date2 = new MyDate(4,10,2008);
        Solid balloons = new Solid("Acme Baloons", 1401, 14, UnitOfMeasureType.CUBIC_FOOT, false, 20, 5, 6);

        Order balloonsOrder = new Order(date2, 1000.00, "Bugs Bunny", balloons, 125);
        balloonsOrder.printOrderObject();
        System.out.println("Length: "+balloons.getLength());
        System.out.println("Volume: " + balloons.calculateVolume());

        MyDate date3 = new MyDate(5, 20, 2008);
        Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,
                false, 1, 6);
        Order glueOrder = new Order(date3, 200, "Road Runner", glue,12);
        glueOrder.printOrderObject();

    }

}
