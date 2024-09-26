package ru.vaganov.naumen.task5;

import java.util.Queue;

public class Task5 implements Task {

    private Queue<Integer> queue;
    private volatile boolean isRunning;

    public Task5(Queue<Integer> queue) {
        this.queue = queue;
        this.isRunning = false;
    }

    @Override
    public void start() {
        isRunning = true;
        new Thread(() -> process()).start();
    }

    @Override
    public void stop() {
        System.out.println("Ручная остановка обработки");
        isRunning = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void process() {
        System.out.println("Начало обработки...");
        try {
            while (isRunning && !queue.isEmpty()) {
                Thread.sleep(500);
                System.out.println("Обработано заначение: " + queue.poll());

            }
        System.out.println("Обработка завершена");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTask() {
        return "Реализуйте интерфейс “Task” для обработки данных, поступающих в очередь";
    }

    public boolean getIsRunning() {
        return isRunning;
    }
}
