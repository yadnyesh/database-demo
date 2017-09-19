package com.in28minutes.database.databasedemo.entity;

/**
 * Created by z063407 on 9/19/17.
 */
public class MyMath {

    int sum (int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
}
