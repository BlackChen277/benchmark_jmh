package black.counter.benchmark.impl;

import black.counter.benchmark.Counter;


public class VolatileCounter implements Counter {
    private volatile long counter;
    @Override
    public long getCount() {
        return counter;
    }
    @Override
    public void increment() {
        ++counter;
    }
}