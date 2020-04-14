
package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter {
    private final ReentrantLock lock;
    private long counter;

    public LockCounter(boolean fair) {
        lock = new ReentrantLock(fair);
    }
    @Override
    public long getCount() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
    @Override
    public void increment() {
        lock.lock();
        try {
            ++counter;
        } finally {
            lock.unlock();
        }
    }
}
