package ru.croc.java.school.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

    @Test
    public void testRunnableThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Задача выполнена " + index);
                }
            };
            Future<?> future = executorService.submit(task);
            futures.add(future);
        }

        for (Future<?> future : futures) {
            while (!future.isDone());
        }

        executorService.shutdown();
    }

    @Test
    public void testCallableThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            Callable<String> taskWithResult = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(Math.abs(new Random().nextInt() % 5000) + 1000); // "долгие вычисления"
                    return "Задача выполнена " + index;
                }
            };
            Future<String> future = executorService.submit(taskWithResult);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            // с ошибками, на память
//            if (future.isDone()) {
//                System.out.println(future.get());
//            } else {
//                while (!future.isDone()) {
//                    // не блокируемся и можем принять решение
//                    // например, заблокироваться
//                    System.out.println(future.get());
//                }
//            }

            while (!future.isDone());
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
