package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;

public class DirtyCounter implements Counter {
    private long counter;
    @Override
    public long getCount() {
        return counter;
    }
    @Override
    public void increment() {
        ++counter;
    }
}
