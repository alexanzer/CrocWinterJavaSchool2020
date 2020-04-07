package ru.croc.java.winter.school.zoo;

public class ExampleExceptions {

    public static void main(String[] args) {
        try {
            f();
            g();
        } catch (RuntimeException e) {
            System.out.println("ho ho ho RUNTIME");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ho ho ho");
        }
    }

    private static void f() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException("Сообщение", e);
        }
    }

    private static void g() {
        throw new RuntimeException();
    }
}
