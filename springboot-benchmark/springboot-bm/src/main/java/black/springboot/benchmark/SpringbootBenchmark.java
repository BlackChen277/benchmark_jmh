package black.springboot.benchmark;

import black.spring.boot.demo.DemoApplication;
import black.spring.boot.demo.model.Person;
import black.spring.boot.demo.service.PersonService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@State(Scope.Benchmark)
public class SpringbootBenchmark {

    private ConfigurableApplicationContext context;
    private PersonService service;

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder().include(SpringbootBenchmark.class.getName() + ".*")
                .warmupIterations(2).measurementIterations(2).forks(1).build();
        new Runner(options).run();
    }

    /**
     * setup初始化容器的时候只执行一次
     */
    @Setup(Level.Trial)
    public void init() {
        context = SpringApplication.run(DemoApplication.class);
        service = context.getBean(PersonService.class);
    }

    @TearDown
    public void finish() {
        context.close();
    }

    @Benchmark
    public void test(Blackhole blackhole) {
        String name = String.valueOf(System.currentTimeMillis());
        Person person = new Person.Builder().personName(name).personAge(10).build();
        blackhole.consume(service.addPerson(person));
    }
}
