package com.acme.domain;

import java.util.*;

public abstract class Good implements Product {

    private String name;
    private int modelNumber;
    private double height;
    private  UnitOfMeasureType UnitOfMeasure;
    private boolean flammable;
    private double weightPerUnitOfMeasure;

    public static void setCatalog(Set catalog) {
        Good.catalog = catalog;
    }

    private static Set catalog;
    static Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER,false, 15, 6);
    static Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65,UnitOfMeasureType.GALLON, true, 0.70, 12);
    static Solid anvil = new Solid("Acme Anvil", 1668, 0.3,UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
    static Solid safe = new Solid("Acme Safe", 1672, 1.0,UnitOfMeasureType.CUBIC_METER, false, 300, 0.5, 0.5);
    static Solid balloon = new Solid("Acme Balloon", 1401, 15,UnitOfMeasureType.CUBIC_FOOT, false, 10, 5, 5);
    static Solid pistol = new Solid("Acme Disintegrating Pistol", 1587, 0.1,UnitOfMeasureType.CUBIC_FOOT, false, 1, 0.5, 2);
    static Liquid nitro = new Liquid("Acme Nitroglycerin", 4289, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);
    static Liquid oil = new Liquid("Acme Oil", 4275, 1.0,UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25);


    public static Set getCatalog() {
        return catalog;
    }

    public static Set getFlamablesList() {
        Set flamables = new HashSet();
        Iterator i = Good.getCatalog().iterator();
        while (i.hasNext()){
            Good x = (Good) i.next();
            if (x.isFlammable()) flamables.add(x);
        }
        return flamables;
    };

    static {

        catalog = new HashSet();
        catalog.add(glue);
        catalog.add(paint);
        catalog.add(anvil);
        catalog.add(safe);
        catalog.add(balloon);
        catalog.add(pistol);
        catalog.add(nitro);
        catalog.add(oil);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
        this.UnitOfMeasure = unitOfMeasure;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public void setWeightPerUnitOfMeasure(double weightPerUnitOfMeasure) {
        this.weightPerUnitOfMeasure = weightPerUnitOfMeasure;
    }

    public String getName() {
        return name;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public double getHeight() {
        return height;
    }

    public UnitOfMeasureType getUnitOfMeasure() {
        return UnitOfMeasure;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public double getWeightPerUnitOfMeasure() {
        return weightPerUnitOfMeasure;
    }

    public Good(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUnitOfMeasure) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.height = height;
        this.UnitOfMeasure = unitOfMeasure;
        this.flammable = flammable;
        this.weightPerUnitOfMeasure = weightPerUnitOfMeasure;
    }
    public String toString(){
        return name + " Model Number: " + modelNumber;
    }

    public abstract double calculateVolume ();

    public double calculateWeight () {
        return calculateVolume()*weightPerUnitOfMeasure;
    }

    public final boolean canShipViaPostOffice() {
        return !isFlammable() & calculateWeight() < 200;
    }
}
