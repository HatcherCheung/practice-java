package com.hatcher;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

/**
 * @author： hatcherCheung
 * @date： 2022/6/21 21:10
 * @description： mockito的基本使用
 */
class Demo01Test {

    @Test
    void add() {
        // 模拟出来的random，可以控制它的返回值
        Random mockRandom = Mockito.mock(Random.class);
        // 让nextInt的返回值等于100
        Mockito.when(mockRandom.nextInt()).thenReturn(100);
        System.out.println(mockRandom.nextInt());
        // 看mockRandom是否执行了nextInt方法,并且执行了一次(次数可省略)
        Mockito.verify(mockRandom, Mockito.times(1)).nextInt();
    }
}