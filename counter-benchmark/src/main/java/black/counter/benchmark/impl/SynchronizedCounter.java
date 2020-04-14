package black.counter.benchmark.impl;

import black.counter.benchmark.Counter;

public class SynchronizedCounter implements Counter {
    private Object lock = new Object();

    private int counter;
    @Override
    public long getCount() {
        synchronized (lock) {
            return counter;
        }
    }
    @Override
    public void increment() {
        synchronized (lock) {
            ++counter;
        }
    }
}
