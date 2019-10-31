package com.acme.domain;

public abstract class Good implements Product {

    private String name;
    private int modelNumber;
    private double height;
    private  UnitOfMeasureType UnitOfMeasure;
    private boolean flammable;
    private double weightPerUnitOfMeasure;

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
