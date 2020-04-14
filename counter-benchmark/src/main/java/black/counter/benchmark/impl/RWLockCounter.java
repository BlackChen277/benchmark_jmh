/*
 * Copyright 2016 M. Isuru Tharanga Chrishantha Perera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package black.counter.benchmark.impl;


import black.counter.benchmark.Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockCounter implements Counter {
    private final ReadWriteLock rwlock;

    private final Lock rlock;
    private final Lock wlock;

    private long counter;

    public RWLockCounter(boolean fair) {
        rwlock = new ReentrantReadWriteLock(fair);
        rlock = rwlock.readLock();
        wlock = rwlock.writeLock();
    }
    @Override
    public long getCount() {
        rlock.lock();
        try {
            return counter;
        } finally {
            rlock.unlock();
        }
    }
    @Override
    public void increment() {
        wlock.lock();
        try {
            ++counter;
        } finally {
            wlock.unlock();
        }
    }
}
