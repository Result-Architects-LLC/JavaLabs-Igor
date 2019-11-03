package com.acme.domain;

import com.acme.util.MyDate;

import java.util.PriorityQueue;

public class Order {
    public static double taxRate;

    private MyDate orderDate;
    private double orderAmount = 0.00;
    private char orderJobSize;
    private double orderDiscountAmount = 0.00;
    private double orderTaxAmount = 0.00;
    private double orderTotalAmount = 0.00;
    private String customer;
    private Product product;
    private int quantity;
    private  static Rushable rushable;

    {taxRate = 0.05;
    }


    public Order(MyDate d, double amt, String c, Product p, int q){
        orderDate=d;
        orderAmount=amt;
        customer=c;
        product=p;
        quantity=q;
        determineJobSize();
        computeDiscount();
        computeTax();
        computeTotal();
    }

    public String toString(){
        return quantity + " ea. " + product + " for " + customer;
    }

    public void computeTax() {
        //System.out.println("The tax for this order is: " + orderAmount*Order.taxRate);
       orderTaxAmount = orderAmount* Order.taxRate;
    }

    public void printOrderObject(){
        System.out.println("The order date is " + this.orderDate.month + "/" + this.orderDate.day + "/" + this.orderDate.year);
        System.out.println("The order amount is " + this.orderAmount);
        System.out.println("The order customer is " + this.customer);
        System.out.println("The order product is " + this.product);
        System.out.println("The quantity of the order is " + this.quantity);
        System.out.println("The job size is " + this.orderJobSize);
        System.out.println("The discount amount is " + this.orderDiscountAmount);
        System.out.println("The tax rate is " + Order.taxRate);
        System.out.println("The tax amount is " + this.orderTaxAmount);
        System.out.println("Your total amount is " + this.orderTotalAmount);
    }
    private void determineJobSize() {
        
        if (orderAmount <= 25) {
            orderJobSize = 'S';
        }
        else if(orderAmount >=25 && orderAmount <=75) {
           orderJobSize = 'M';
        }
        else if(orderAmount >=76 && orderAmount <=150) {
            orderJobSize = 'L';
        }
        else {
            orderJobSize = 'X';
        }
        
    }

    private void computeDiscount() {

        if (orderJobSize == 'S') {
            orderDiscountAmount = orderAmount * 0.00;
        }
        else if (orderJobSize == 'M') {
            orderDiscountAmount = orderAmount * 0.01;
        }
        else if (orderJobSize == 'L') {
            orderDiscountAmount = orderAmount * 0.02;
        }
        else if (orderJobSize == 'X') {
            orderDiscountAmount = orderAmount * 0.03;
        }
    }

//    setTaxRate method is static because the same tax rate applies for all orders
    public static void setTaxRate (double newRate) {
        taxRate = newRate;
    }

    public void computeTotal() {
        if (orderAmount <= 1500) {
            orderTotalAmount = orderAmount  - orderDiscountAmount + orderTaxAmount;
        }
        else{
            orderTotalAmount = orderAmount - orderDiscountAmount;
        }
    }
public boolean isPriorityOrder () {
        boolean priorityOrder;
         priorityOrder = rushable.isRushable(orderDate, orderAmount);
//        if (rushable != null) {
//        priorityOrder = rushable.isRushable(orderDate, orderAmount);
//    }
        return priorityOrder;
    }

    public Product getProduct() {
        return product;
    }

    public static void setRushable(Rushable rushable) {
       Order.rushable = rushable;
    }

    public static Rushable getRushable() {
        return rushable;
    }
}
