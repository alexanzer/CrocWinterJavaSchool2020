package ru.croc.java.school.thread;

public class RaceCondition {
    boolean flag;

    void thread1() {
        while (!flag) {
            System.out.println("Ждём");
        }
    }

    void thread2() {
        flag = true;
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
        new RaceCondition().example();
    }
}
