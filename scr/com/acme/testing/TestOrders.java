package com.acme.testing;

import com.acme.domain.*;
import com.acme.domain.Rushable;
import com.acme.util.MyDate;

public class TestOrders {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // I am a little unclear about Lambda so below is my best explanation for myself
        // Rushable is an interface and I need to declare a reference variable whose type is interface.
        Rushable myRushable;
        // Next, I use myRushable reference variable whose type is interface to specify Lambda;
        // At this point isRushable method inside Rushable functional interface is still not defined; still abstract.
        myRushable = (myDate, amount) -> ((amount > 1500) || myDate.daysBetweenTodayAndMyDate()>30);
        // Now, I set private  static Rushable rushable variable to myRushable for class Order.
        // Note, that rushable is a static variable so for all objects of class Order rushable is set to my Lambda expression above;
        // Question: why does Order not "implement" Rushable interface? When would it be appropriate?
        Order.setRushable(myRushable);

        MyDate date1 = new MyDate(1,1,2016);
        Solid anvil = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 5000, 0.5, 0.5);
        Order anvilOrder = new Order(date1, 2000.00, "Wile E Coyote",anvil, 10);
        anvilOrder.printOrderObject();

        // on the next line I get product from the order and then cast it as Solid so that I can use getLength method. This is an extra credit problem that demonstrates that casting may be necessary when working with inheritance and polymorphism

        if(anvilOrder.getProduct() instanceof Solid) {
            System.out.println("Length: " + ((Solid) anvilOrder.getProduct()).getLength());
        }
        // on the next line I simply call getLength because I have anvil reference variable available in my code. This is a simpler alternative to the above code.  However, often you would not have a reference variable of the right type available and then casting would be required.

        System.out.println("Length: "+ anvil.getLength());
        System.out.println("Volume: " + anvil.calculateVolume());
        System.out.println(anvilOrder.getProduct().getName() +" is Priority order " + anvilOrder.isPriorityOrder());

        MyDate date2 = new MyDate(4,10,2008);
        Solid balloons = new Solid("Acme Balloons", 1401, 14, UnitOfMeasureType.CUBIC_FOOT, false, 20, 5, 6);

        Order balloonsOrder = new Order(date2, 1000.00, "Bugs Bunny", balloons, 125);
        balloonsOrder.printOrderObject();
        System.out.println("Length: "+balloons.getLength());
        System.out.println("Volume: " + balloons.calculateVolume());
        System.out.println(balloonsOrder.getProduct().getName() +" is Priority order " + balloonsOrder.isPriorityOrder());

        MyDate date3 = new MyDate(1, 2, 2020);
        Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,
                false, 1, 6);
        Order glueOrder = new Order(date3, 200, "Road Runner", glue,12);
        glueOrder.printOrderObject();

        MyDate date4 = new MyDate(25, 12, 2016);
        Service rrEradication = new Service("Road Runner Eradication", 22, false);

        Order rrEradicationOder = new Order(date4, 200, "Duffy Duck", rrEradication,1);
        rrEradicationOder.printOrderObject();

    }

}
