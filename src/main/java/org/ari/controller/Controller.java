package org.ari.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Controller {
    private String salaisuus = "salaisuus 1";
    boolean running = true;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> start() {
        System.out.println("Controller("+salaisuus+") starting.");
        return executor.submit(()->controlLoop());
    }

    public String stop() {
        running = false;
        return "Controller("+salaisuus+") stopping.";
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

    public String execute(Command command) {
        String result = null;
        CommandType commandType = command.getCommandType();
        switch (commandType) {
            case STOP:
                result = this.stop();
                break;
   //         case CREATE_ARMY:
   //             this.getRoster().createArmy();
            default:
        }
        return result;
    }
}
