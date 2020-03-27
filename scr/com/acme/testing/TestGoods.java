package com.acme.testing;

import com.acme.domain.Good;
import com.acme.domain.Liquid;
import com.acme.domain.UnitOfMeasureType;
import com.acme.domain.Solid;

public class TestGoods {

    public static void main(String[] args) {
        Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,
                false, 1, 6);
        Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65,
                UnitOfMeasureType.GALLON, true, 0.70, 12);
        Solid anvil = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 5000, 0.5, 0.5);

        System.out.println(glue);
        System.out.println(paint);
        System.out.println(anvil);

        System.out.println("The weight of " + glue.getName() + " is " + glue.calculateWeight());
        System.out.println("The weight of " + paint.getName() + " is " + paint.calculateWeight());
        System.out.println("The weight of " + anvil + " is " + anvil.calculateWeight());

        Good x = glue;
        System.out.println("Is " + x.getName() + " flammable?  " + x.isFlammable());
        x = paint;
        System.out.println("Is " + x.getName() + " flammable?  " + x.isFlammable());
        x = anvil;
        System.out.println("Is " + x.getName() + " flammable?  " + x.isFlammable());

        System.out.println(glue + " can ship via Post office? " + glue.canShipViaPostOffice());
        System.out.println(anvil + " can ship via Post office? " + anvil.canShipViaPostOffice());
        System.out.println(paint + " can ship via Post office? " + paint.canShipViaPostOffice());

        System.out.println("Catalog v1 " + Good.getCatalog());
        Good.getCatalog().remove(paint);
        System.out.println("Catalog v2 " + Good.getCatalog());
        Solid toaster = new Solid("Acme Toaster", 1755, 0.75, UnitOfMeasureType.CUBIC_FOOT, true, 1, 1, 1);
        Good.getCatalog().add(toaster);
        System.out.println("Catalog v3 " + Good.getCatalog());
        Good.getCatalog().add(toaster);
        System.out.println("Catalog v4 " + Good.getCatalog());

        System.out.println("Flammable products " + Good.getFlamablesList());
    }
}
