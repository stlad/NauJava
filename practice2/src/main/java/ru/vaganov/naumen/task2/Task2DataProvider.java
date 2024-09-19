package ru.vaganov.naumen.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2DataProvider {

    public List<Double> initRandoms(int n) {
        List<Double> data = new ArrayList<>(n);
        double min = -1000;
        double max = 1000;

        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            data.add(random.nextDouble() * (max - min) + min);
        }
        return data;
    }
}
