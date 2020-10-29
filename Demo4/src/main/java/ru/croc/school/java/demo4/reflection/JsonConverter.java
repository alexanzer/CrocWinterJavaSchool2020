package ru.croc.school.java.demo4.reflection;

import java.lang.reflect.Field;

public class JsonConverter {


    public String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder("{\n");
        for (Field field : fields) {
            final String name = field.getName();
            final String value;
            if (field.getType().equals(String.class)) {
                value =(String) field.get(obj);
            } else {
                value = field.get(obj).toString();
            }
            json.append(String.format("  %s: \"%s\",\n", name, value));
        }
        json.append("}");

        return json.toString();
    }
}
