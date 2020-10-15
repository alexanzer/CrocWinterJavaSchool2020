package ru.croc.java.school.lec2;

public class Optional<T, E> {
    private T value;
    private E e;

    public Optional(T value, E e) {
        this.value = value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public T getValue() {
        return value;
    }

    public static <String> String f(String value) {
        return value;
    }

    public static void main(String[] args) {
        Optional<String, Integer> optional = new Optional<>("string", 5);
        System.out.println(optional.isPresent());
        System.out.println(optional.getValue());

        System.out.println(Optional.f(7));
    }
}
