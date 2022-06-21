package com.hatcher;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Random;

/**
 * @author： hatcherCheung
 * @date： 2022/6/21 21:10
 * @description： mockito注解+junit注解的使用
 */
class Demo03Test {
    //使用注解来代替Mockito.mock
    @Mock
    private Random mockRandom;

    @BeforeEach
    public void init() {
        System.out.println("=====BeforeEach方法执行=====");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void add() {
        // 让nextInt的返回值等于100
        Mockito.when(mockRandom.nextInt()).thenReturn(100);
        System.out.println(mockRandom.nextInt());
        // 看mockRandom是否执行了nextInt方法,并且执行了一次(次数可省略)
        Mockito.verify(mockRandom, Mockito.times(1)).nextInt();
    }


    @AfterEach
    public void destroy() {
        System.out.println("=====AfterEach 方法执行=====");
    }
}