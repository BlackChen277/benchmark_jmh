package black.util.benchmark.utils;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomStringUtilsGenerator {

    /**
     * 生成指定长度的随机串
     **/
    public static String generateCode(int count) {
        return RandomStringUtils.random(count, 0, 0, true, true);
    }
}