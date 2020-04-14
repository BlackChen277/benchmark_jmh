package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;

public class SynchronizedMethodCounter implements Counter {
    private Object lock = new Object();

    private int counter;
    @Override
    public synchronized long getCount() {
        return counter;
    }
    @Override
    public synchronized void increment() {
        ++counter;
    }
}
