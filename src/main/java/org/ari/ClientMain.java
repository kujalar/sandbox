package org.ari;

import org.ari.controller.rmi.CommandPort;
import org.ari.controller.rmi.TestTask;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static void main(String args[]) {
        /*
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
        try {
            String name = "rmiCommandPort";
            Registry registry = LocateRegistry.getRegistry();
            CommandPort comp = (CommandPort) registry.lookup(name);
            TestTask task = new TestTask();
            String result = comp.executeTask(task);
            System.out.println("Task was executed with result: "+result);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
