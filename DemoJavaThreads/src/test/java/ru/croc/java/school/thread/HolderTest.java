package ru.croc.java.school.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class HolderTest {

    class Inc implements Runnable {
        final Holder holder;

        public Inc(Holder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                synchronized (holder) {
                    holder.value++;
                }
            }
        }
    }

    class IncAtomic implements Runnable {
        final AtomicInteger holder;

        public IncAtomic(AtomicInteger holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                holder.incrementAndGet();
            }
        }
    }

    @Test
    public void testChange() throws InterruptedException {
        Holder holder = new Holder();
        holder.value = 0;

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Inc(holder));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(10 * 100_000, holder.value);
    }

    @Test
    public void testAtomic() throws InterruptedException {
        final AtomicInteger holder = new AtomicInteger(0);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new IncAtomic(holder));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(10 * 100_000, holder.get());
    }
}
