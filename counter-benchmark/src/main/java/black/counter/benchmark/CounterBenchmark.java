
package black.counter.benchmark;

import black.counter.benchmark.impl.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.atomic.LongAdder;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(1)
public class CounterBenchmark {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(CounterBenchmark.class.getSimpleName())
                .forks(1)
                .measurementIterations(1)
                .warmupIterations(1)
                .resultFormat(ResultFormatType.JSON)
                .result("log/benchmark_counter.json")
                .build();

        LongAdder longAdder = new LongAdder();
        new Runner(opt).run();
    }

    @Benchmark
    @Group("Adder")
    @GroupThreads(60)
    public void incAdder(AdderCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Adder")
    @GroupThreads(40)
    public long getAdder(AdderCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("Atomic")
    @GroupThreads(60)
    public void incAtomic(AtomicCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Atomic")
    @GroupThreads(40)
    public long getAtomic(AtomicCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("Dirty")
    @GroupThreads(60)
    public void incDirty(DirtyCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Dirty")
    @GroupThreads(40)
    public long getDirty(DirtyCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("LockFair")
    @GroupThreads(60)
    public void incFairLock(FairLockCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("LockFair")
    @GroupThreads(40)
    public long getFairLock(FairLockCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("LockNonFair")
    @GroupThreads(60)
    public void incNonFairLock(NonFairLockCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("LockNonFair")
    @GroupThreads(40)
    public long getNonFairLock(NonFairLockCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("RWLockFair")
    @GroupThreads(60)
    public void incFairRWLock(FairRWLockCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("RWLockFair")
    @GroupThreads(40)
    public long getFairRWLock(FairRWLockCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("RWLockNonFair")
    @GroupThreads(60)
    public void incNonFairRWLock(NonFairRWLockCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("RWLockNonFair")
    @GroupThreads(40)
    public long getNonFairRWLock(NonFairRWLockCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("Synchronized")
    @GroupThreads(60)
    public void incSynchronized(SynchronizedCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Synchronized")
    @GroupThreads(40)
    public long getSynchronized(SynchronizedCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("SynchronizedMethod")
    @GroupThreads(60)
    public void incSynchronizedMethod(SynchronizedMethodCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("SynchronizedMethod")
    @GroupThreads(40)
    public long getSynchronizedMethod(SynchronizedMethodCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("Volatile")
    @GroupThreads(60)
    public void incVolatile(VolatileCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Volatile")
    @GroupThreads(40)
    public long getVolatile(VolatileCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("StampedOptimistic")
    @GroupThreads(60)
    public void incOptimisticStamped(OptimisticStampedCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("StampedOptimistic")
    @GroupThreads(40)
    public long getOptimisticStamped(OptimisticStampedCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("Stamped")
    @GroupThreads(60)
    public void incStamped(StampedCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("Stamped")
    @GroupThreads(40)
    public long getStamped(StampedCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("SemaphoreFair")
    @GroupThreads(60)
    public void incFairSemaphore(FairSemaphoreCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("SemaphoreFair")
    @GroupThreads(40)
    public long getFairSemaphore(FairSemaphoreCounterState state) {
        return state.counter.getCount();
    }

    @Benchmark
    @Group("SemaphoreNonFair")
    @GroupThreads(60)
    public void incNonFairSemaphore(NonFairSemaphoreCounterState state) {
        state.counter.increment();
    }

    @Benchmark
    @Group("SemaphoreNonFair")
    @GroupThreads(40)
    public long getNonFairSemaphore(NonFairSemaphoreCounterState state) {
        return state.counter.getCount();
    }

    @State(Scope.Group)
    public static class AdderCounterState {
        Counter counter = new AdderCounter();
    }

    @State(Scope.Group)
    public static class AtomicCounterState {
        Counter counter = new AtomicCounter();
    }

    @State(Scope.Group)
    public static class DirtyCounterState {
        Counter counter = new DirtyCounter();
    }

    @State(Scope.Group)
    public static class FairLockCounterState {
        Counter counter = new LockCounter(true);
    }

    @State(Scope.Group)
    public static class NonFairLockCounterState {
        Counter counter = new LockCounter(false);
    }

    @State(Scope.Group)
    public static class FairRWLockCounterState {
        Counter counter = new RWLockCounter(true);
    }

    @State(Scope.Group)
    public static class NonFairRWLockCounterState {
        Counter counter = new RWLockCounter(false);
    }

    @State(Scope.Group)
    public static class SynchronizedCounterState {
        Counter counter = new SynchronizedCounter();
    }

    @State(Scope.Group)
    public static class SynchronizedMethodCounterState {
        Counter counter = new SynchronizedMethodCounter();
    }

    @State(Scope.Group)
    public static class VolatileCounterState {
        Counter counter = new VolatileCounter();
    }

    @State(Scope.Group)
    public static class OptimisticStampedCounterState {
        Counter counter = new OptimisticStampedCounter();
    }

    @State(Scope.Group)
    public static class StampedCounterState {
        Counter counter = new StampedCounter();
    }

    @State(Scope.Group)
    public static class FairSemaphoreCounterState {
        Counter counter = new SemaphoreCounter(true);
    }

    @State(Scope.Group)
    public static class NonFairSemaphoreCounterState {
        Counter counter = new SemaphoreCounter(false);
    }


}
