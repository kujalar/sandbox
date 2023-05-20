package org.ari;

import org.ari.combat.Resolver;
import org.ari.controller.Controller;
import org.ari.controller.rmi.CommandPort;
import org.ari.controller.rmi.CommandPortImpl;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //TODO https://docs.oracle.com/javase/tutorial/rmi/designing.html
        /*
        System.out.println(args.length);
        System.setProperty("java.security.manager","allow");
        if(System.getSecurityManager()==null) {
            System.setSecurityManager(new SecurityManager());
        }*/
        Controller controller = new Controller();
        CommandPort rmiCommandPort;
        try {
        //    System.setProperty("java.rmi.server.hostname","192.168.56.1");
            String name = "rmiCommandPort";
            rmiCommandPort = new CommandPortImpl(controller);
            CommandPort stub = (CommandPort) UnicastRemoteObject.exportObject(rmiCommandPort,0);
            Registry registry = LocateRegistry.createRegistry(1099);
        //    Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("rmiCommandPort bound");
        } catch (RemoteException re) {
            System.err.println("rmiCommandPort exception:");
            re.printStackTrace();
            rmiCommandPort = null;
        }




        Future<Integer> future1 = controller.start(rmiCommandPort);

        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome! ");

        Resolver resolver = new Resolver();
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
            resolver.meleeCombat("human-"+i, "orc-"+i);
        }

        controller.stop();

        try {
            Integer result = future1.get();
            System.out.println("status = "+result);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        } catch (ExecutionException ee) {
            System.out.println(ee);
        }
        System.out.println("Stopping the main");
    }
}