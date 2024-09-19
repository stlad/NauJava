package ru.vaganov.naumen.task1;

import java.util.Random;

public class Task1DataProvider {

    public Integer[] initRandoms(int n){
        Integer[] array = new Integer[n];
        Random random = new Random();
        for(int i =0; i<array.length; ++i){
            array[i] = random.nextInt();
        }
        return array;
    }
}
