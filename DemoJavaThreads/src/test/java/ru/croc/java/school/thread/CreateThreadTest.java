package ru.croc.java.school.thread;

import org.junit.jupiter.api.Test;

public class CreateThreadTest {

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello Runnable");
        }
    }


    @Test
    public void createThread() throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(10_000);
        System.out.println("Hello Main");
    }

    @Test
    public void createThreadWithRunnable() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread.sleep(10_000);
        System.out.println("Hello Main");
    }

    @Test
    public void createLambda() {
        Thread thread = new Thread(() -> System.out.println("Hello Lambda Thread"));
        thread.start();
    }
}
