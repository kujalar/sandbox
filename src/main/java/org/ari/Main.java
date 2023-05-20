package org.ari;

import org.ari.combat.Resolver;
import org.ari.controller.Controller;
import org.ari.rmi.RmiServer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting main.");
        //TODO https://docs.oracle.com/javase/tutorial/rmi/designing.html
        /*
        System.out.println(args.length);
        */
        Controller controller = new Controller();
        Future<Integer> future1 = controller.start();
        RmiServer rmiServer = new RmiServer(controller);
/*
        Resolver resolver = new Resolver();
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
            resolver.meleeCombat("human-"+i, "orc-"+i);
        }
*/
        try {
            //wait here for controller stop which initiates shutdown
            Integer result = future1.get();
            System.out.println("Controller successfully stopped. status = "+result);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        } catch (ExecutionException ee) {
            System.out.println(ee);
        }

        rmiServer.shutDown();
        System.out.println("Stopping the main");
        System.exit(0);
    }
}