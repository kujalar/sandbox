package org.ari.rmi;

import org.ari.controller.Controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer {
    CommandPort rmiCommandPort = null;
    CommandPort stub = null;
    Registry registry =  null;
    private final String name = "rmiCommandPort";
    public RmiServer(Controller controller) {
        super();
        start(controller);
    }

    private void start(Controller controller) {
        System.out.println("RmiServer starting.");
        try {
            //    System.setProperty("java.rmi.server.hostname","192.168.56.1");

            rmiCommandPort = new CommandPortImpl(controller);
            stub = (CommandPort) UnicastRemoteObject.exportObject(rmiCommandPort,0);
            registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, stub);
            System.out.println("rmiCommandPort bound");
            System.out.println("RmiServer started.");
        } catch (RemoteException re) {
            System.err.println("rmiCommandPort exception:");
            re.printStackTrace();
        }
    }
    public String getName() {
        return name;
    }
    public void shutDown() {
        try {
            System.out.println("Shutting down the RmiServer.");
            UnicastRemoteObject.unexportObject(registry,true);
            if(registry!=null) {
                //         registry.unbind(rmiCommandPortName); ei taida olla tarpeellinen tässä
            }
        } catch (RemoteException re) {
            System.err.println("rmiCommandPort exception:");
            re.printStackTrace();
        }
    }

}
