package com.acme.domain;

public class Liquid extends Good {

    private double radiusOfContainer;

    public double getRadiusOfContainer() {
        return radiusOfContainer;
    }

    public void setRadiusOfContainer(double radiusOfContainer) {
        this.radiusOfContainer = radiusOfContainer;
    }
    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double weightPerUnitOfMeasure, double radiusOfContainer) {
    super(name, modelNumber, height, uoM, flammable,weightPerUnitOfMeasure);
    setRadiusOfContainer(radiusOfContainer);
    }

    public double calculateVolume () {
        return Math.PI * radiusOfContainer * getHeight();
    }

    public String toString () {
        return super.toString() + " (liquid) " + calculateVolume() + " " + getUnitOfMeasure();
    }
}
