package org.ari;

import org.ari.controller.CommandType;
import org.ari.rmi.CommandPort;
import org.ari.rmi.ControllerTask;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static void main(String args[]) {
        try {
            String name = "rmiCommandPort";
            Registry registry = LocateRegistry.getRegistry();
            CommandPort comp = (CommandPort) registry.lookup(name);
            ControllerTask stop = new ControllerTask(CommandType.STOP);
            String result = comp.executeTask(stop);
            System.out.println("Task was executed with result: "+result);
        } catch (Exception e) {
            System.err.println("Exception while executing the program:");
            e.printStackTrace();
        }
    }
}
