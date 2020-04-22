package black.util.benchmark;

import black.util.benchmark.utils.RandomStringUtilsGenerator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class RandomStringBenchmark {

    @Param(value = {"5", "10", "13"})
    public int length;

    @Benchmark
    public void randomStringBenchmark(Blackhole blackhole) {
        blackhole.consume(RandomStringUtilsGenerator.generateCode(length));
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(RandomStringBenchmark.class.getSimpleName())
                .forks(2)
                .measurementIterations(3)
                .warmupIterations(1)
                .build();
        new Runner(opt).run();
    }
}
