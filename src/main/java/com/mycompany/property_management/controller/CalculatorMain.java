package com.mycompany.property_management.controller;

public class CalculatorMain {
    public static void main(String[] args){
        CalculatorController cc=new CalculatorController();
        Double result=cc.add(6.9,9.5,8.5);
        System.out.println(result);
    }
}
