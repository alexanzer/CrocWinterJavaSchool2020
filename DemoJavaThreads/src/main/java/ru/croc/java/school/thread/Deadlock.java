package ru.croc.java.school.thread;

public class Deadlock {
    Object lock1 = new Object();
    Object lock2 = new Object();
    boolean flag = false;
    String expectedValue = null;

    void thread1() {
        synchronized (lock1) {
            while (!flag) {
                System.out.println("Ждем сообщения");
            }
            synchronized (lock2) {
                System.out.println(expectedValue);
            }
        }
    }

    void thread2() {
        synchronized (lock2) {
            expectedValue = "Сообщение для потока 1";
            synchronized (lock1) {
                flag = true; // сообщение записано
            }
        }
    }

    void example() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                thread1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                thread2();
            }
        }).start();
    }

    public static void main(String[] args) {
        new Deadlock().example();
    }
}
