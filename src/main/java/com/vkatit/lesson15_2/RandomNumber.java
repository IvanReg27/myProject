package com.vkatit.lesson15_2;

import java.util.ArrayList;

public class RandomNumber {

    public static void main(String[] args) {

        Thread thread = new Thread();


        int a = (int) (Math.random() * 1_000_000);

        ArrayList<Integer> number = new ArrayList<Integer>();
        number.add(a);

        System.out.println(number);
    }
}