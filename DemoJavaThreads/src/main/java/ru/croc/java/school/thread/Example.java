package ru.croc.java.school.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {

    Lock lock = new ReentrantLock();
    boolean value = false;

    void update() {
        lock.lock();
        try {
            value = true;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
    }
}
