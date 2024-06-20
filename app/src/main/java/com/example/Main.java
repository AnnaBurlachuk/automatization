package com.example;

public class Main {
    public static void main(String[] args) {

        try {
            Phone phone = Phone.create(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Phone phone = Phone.create("12345678");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        HelloWorldClass0 helloWorldClass0 = new HelloWorldClass0();
        helloWorldClass0.helloFromPhone();
    }
}