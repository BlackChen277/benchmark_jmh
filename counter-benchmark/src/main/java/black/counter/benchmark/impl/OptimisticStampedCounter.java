package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;

import java.util.concurrent.locks.StampedLock;

public class OptimisticStampedCounter implements Counter {

    private StampedLock rwlock = new StampedLock();

    private long counter;
    @Override
    public long getCount() {
        long stamp = rwlock.tryOptimisticRead();
        long currentCount;
        if (rwlock.validate(stamp)) {
            currentCount = counter;
        } else {
            stamp = rwlock.readLock();
            try {
                currentCount = counter;
            } finally {
                rwlock.unlockRead(stamp);
            }
        }
        return currentCount;
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
