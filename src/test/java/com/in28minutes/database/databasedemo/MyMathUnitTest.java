package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.MyMath;
import org.junit.Test;

/**
 * Created by z063407 on 9/19/17.
 */
public class MyMathUnitTest {

    @Test
    public void sum_with3numbers() {
        MyMath myMath = new MyMath();
        int result = myMath.sum(new int[]{1,2,3});
        assert(result == 6);
    }
}
