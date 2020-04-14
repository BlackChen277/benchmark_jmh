package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;
import java.util.concurrent.Semaphore;

public class SemaphoreCounter implements Counter {

    private final Semaphore semaphore;
    private long counter;

    public SemaphoreCounter(boolean fair) {
        semaphore = new Semaphore(1, fair);
    }
    @Override
    public long getCount() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            return counter;
        } finally {
            semaphore.release();
        }
    }
    @Override
    public void increment() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            ++counter;
        } finally {
            semaphore.release();
        }
    }
}
