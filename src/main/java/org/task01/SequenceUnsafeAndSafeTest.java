package org.task01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequenceUnsafeAndSafeTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        Sequence sequence = new Sequence();
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                unsafeSequence.getNext();
                sequence.getNext();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(sequence.getValue());
        System.out.println(unsafeSequence.getValue());
    }
}
