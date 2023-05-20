package org.ari.controller;

import org.ari.controller.rmi.CommandPort;
import org.ari.controller.rmi.Task;
import org.ari.controller.rmi.TestTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller {
    private String salaisuus = "salaisuus 1";
    boolean running = true;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> start(CommandPort commandPort) {
        System.out.println("Start Controller");
        return executor.submit(()->controlLoop());
    }

    public void stop() {
        running = false;
    }
    private Integer controlLoop() {
        try {
            while (running) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie);
            return 1;
        }
        System.out.println("Stopping Controller");
        return 0;
    }

    public <T> T execute(Task<T> task) {
        if(task instanceof TestTask) {
            ((TestTask) task).setResult(salaisuus);
        }
        return task.execute();
    }
}
