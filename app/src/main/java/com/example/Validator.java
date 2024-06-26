package com.example;

import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MyNotNull.class)) {
                field.setAccessible(true);
                var value = field.get(obj);
                if (value == null) {
                    throw new IllegalArgumentException("Can't be null");
                }
            }
        }
    }
}
