package com.demo.tifone.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyCalculateTest {
    private MyCalculate mCalculate;

    @Before
    public void setup() {
        mCalculate = new MyCalculate();
    }

    @Test
    public void addMethodTest() {
        assertEquals(mCalculate.add(1, 3), 4);
        assertEquals(mCalculate.add("a", "b"), "ab");
    }
}
