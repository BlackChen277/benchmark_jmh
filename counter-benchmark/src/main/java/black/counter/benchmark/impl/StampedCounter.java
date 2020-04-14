package black.counter.benchmark.impl;

import black.counter.benchmark.Counter;

import java.util.concurrent.locks.StampedLock;

public class StampedCounter implements Counter {

    private StampedLock rwlock = new StampedLock();

    private long counter;
    @Override
    public long getCount() {
        long stamp = rwlock.readLock();
        try {
            return counter;
        } finally {
            rwlock.unlockRead(stamp);
        }
    }

    @Override
    public void increment() {
        long stamp = rwlock.writeLock();
        try {
            ++counter;
        } finally {
            rwlock.unlockWrite(stamp);
        }
    }
}
