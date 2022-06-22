package com.hatcher;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author： hatcherCheung
 * @date： 2022/6/21 23:48
 * @description： 用来测试mockito的静态方法模拟的类
 */
public class StaticMockTest {
    // 返回指定范围的数
    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end).boxed().collect(Collectors.toList());
    }

    // 返回字符串Echo
    public static String getEcho() {
        return "Echo";
    }
}
