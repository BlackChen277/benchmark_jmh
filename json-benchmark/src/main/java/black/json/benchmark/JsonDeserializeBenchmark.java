package black.json.benchmark;

import black.json.benchmark.model.BenchmarkModel;
import black.json.benchmark.utils.FastJsonUtils;
import black.json.benchmark.utils.GsonUtils;
import black.json.benchmark.utils.JacksonUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class JsonDeserializeBenchmark {

    private String str;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(JsonDeserializeBenchmark.class.getSimpleName())
                .forks(1)
                .measurementIterations(3)
                .warmupIterations(2)
                .resultFormat(ResultFormatType.JSON)
                .result("log/benchmark_json_deserialize.json")
                .output("log/benchmark_json_deserialize.log")
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void Gson(Blackhole bh) {
        bh.consume(GsonUtils.json2Bean(str, BenchmarkModel.class));
    }

    @Benchmark
    public void FastJson(Blackhole bh) {
        bh.consume(FastJsonUtils.json2Bean(str, BenchmarkModel.class));
    }

    @Benchmark
    public void Jackson(Blackhole bh) {
        bh.consume(JacksonUtils.json2Bean(str, BenchmarkModel.class));
    }

    @Setup
    public void prepare() {
        str = "{\n" +
                "    \"_id\": \"5e9067400c44adf85e67ceb3\",\n" +
                "    \"index\": 0,\n" +
                "    \"guid\": \"a549c842-294b-4d29-9292-389acbc51c5e\",\n" +
                "    \"isActive\": true,\n" +
                "    \"balance\": \"$3,486.64\",\n" +
                "    \"picture\": \"http://placehold.it/32x32\",\n" +
                "    \"age\": 21,\n" +
                "    \"eyeColor\": \"green\",\n" +
                "    \"name\": \"Nadia Casey\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"company\": \"ULTRASURE\",\n" +
                "    \"email\": \"nadiacasey@ultrasure.com\",\n" +
                "    \"phone\": \"+1 (820) 485-2246\",\n" +
                "    \"address\": \"166 Buffalo Avenue, Aurora, Missouri, 9311\",\n" +
                "    \"about\": \"Quis occaecat occaecat nulla laborum deserunt ut velit ipsum duis et magna eiusmod nisi. Irure enim sunt dolor dolor amet incididunt ea aliqua. Sit labore incididunt duis ex esse laboris cillum. Ullamco cillum proident amet in cillum sint aliqua reprehenderit reprehenderit excepteur voluptate excepteur officia. Sunt dolor nostrud laborum sit anim qui nulla culpa duis quis voluptate adipisicing ut. Id commodo commodo tempor incididunt. Lorem elit ut aute sunt adipisicing.\\r\\n\",\n" +
                "    \"registered\": \"2017-12-16T07:31:26 -08:00\",\n" +
                "    \"latitude\": 81.66353,\n" +
                "    \"longitude\": 5.415652,\n" +
                "    \"tags\": [\n" +
                "      \"cupidatat\",\n" +
                "      \"labore\",\n" +
                "      \"velit\",\n" +
                "      \"consectetur\",\n" +
                "      \"officia\",\n" +
                "      \"magna\",\n" +
                "      \"sit\"\n" +
                "    ],\n" +
                "    \"friends\": [\n" +
                "      {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"Summers Walker\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Casey Mann\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Tracy Ballard\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"greeting\": \"Hello, Nadia Casey! You have 3 unread messages.\",\n" +
                "    \"favoriteFruit\": \"apple\"\n" +
                "  }";
    }

    @TearDown
    public void shutdown() {
    }
}
