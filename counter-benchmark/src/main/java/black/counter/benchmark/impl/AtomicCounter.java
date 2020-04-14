package black.counter.benchmark.impl;

import black.counter.benchmark.Counter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter implements Counter {
    private final AtomicLong atomic = new AtomicLong();
    @Override
    public long getCount() {
        return atomic.get();
    }
    @Override
    public void increment() {
        atomic.incrementAndGet();
    }
}
