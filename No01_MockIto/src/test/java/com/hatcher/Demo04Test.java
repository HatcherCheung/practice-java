package com.hatcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

/**
 * @author： hatcherCheung
 * @date： 2022/6/22 10:28
 * @description： 静态方法的mock
 */
class Demo04Test {
    /**
     * 有参静态方法的mock
     */
    @Test
    void range() {
        // 使用Mockito.mockStatic方法对有静态方法的类进行模拟，用完需要释放资源(使用try-with-resource自动释放)
        try (MockedStatic<StaticMockTest> staticMock = Mockito.mockStatic(StaticMockTest.class)) {
            // 对静态方法进行打桩
            staticMock.when(() -> StaticMockTest.range(10, 20)).thenReturn(Arrays.asList(10, 22));
            // 调用原来类的静态方法，不是模拟的类
            Assertions.assertTrue(StaticMockTest.range(10, 20).contains(10));
        }

    }

    /**
     * 无参静态方法的mock
     */
    @Test
    void getEcho() {
        try (MockedStatic<StaticMockTest> staticMock = Mockito.mockStatic(StaticMockTest.class)) {
            staticMock.when(StaticMockTest::getEcho).thenReturn("hatcher");
            Assertions.assertEquals("hatcher", StaticMockTest.getEcho());
        }
    }
}