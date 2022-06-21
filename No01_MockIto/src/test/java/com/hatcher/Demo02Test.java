package com.hatcher;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Random;

/**
 * @author： hatcherCheung
 * @date： 2022/6/21 21:10
 * @description： mockito注解的使用
 */
class Demo02Test {
    //使用注解来代替Mockito.mock
    @Mock
    private Random mockRandom;

    @Spy
    private Random mockRandomSpy;

    @Test
    void add() {
        MockitoAnnotations.openMocks(this);
        // 让nextInt的返回值等于100
        Mockito.when(mockRandom.nextInt()).thenReturn(100);
        System.out.println(mockRandom.nextInt());
        // 看mockRandom是否执行了nextInt方法,并且执行了一次(次数可省略)
        Mockito.verify(mockRandom, Mockito.times(1)).nextInt();
    }

    @Test
    void addSpy() {
        MockitoAnnotations.openMocks(this);
        //no when：627194343
        System.out.println("no when：" + mockRandomSpy.nextInt());
        Mockito.when(mockRandomSpy.nextInt()).thenReturn(114514);
        //already when：114514
        System.out.println("already when：" + mockRandomSpy.nextInt());
    }
}