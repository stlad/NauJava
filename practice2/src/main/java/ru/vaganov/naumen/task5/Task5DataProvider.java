package ru.vaganov.naumen.task5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Task5DataProvider {

    public Queue<Integer> initQueue(Integer n){
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i< n;++i){
            queue.add(random.nextInt() % 1000); // Добавим случайное целое в диапазоне [0; 999]
        }
        return queue;
    }
}
