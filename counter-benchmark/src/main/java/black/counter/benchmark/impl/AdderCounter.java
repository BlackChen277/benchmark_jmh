package black.counter.benchmark.impl;

import black.counter.benchmark.Counter;

import java.util.concurrent.atomic.LongAdder;

public class AdderCounter implements Counter {
    private final LongAdder adder = new LongAdder();

    @Override
    public long getCount() {
        return adder.longValue();
    }
    @Override
    public void increment() {
        adder.increment();
    }
}
