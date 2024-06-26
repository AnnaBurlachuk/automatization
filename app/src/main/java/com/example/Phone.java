package com.example;

@GenerateHelloClass
public class Phone {

    @MyNotNull
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }

    public static Phone create(String number) {
        Phone phone = new Phone(number);
        try {
            Validator.validate(phone);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Validation failed", e);
        }
        return phone;
    }
}
