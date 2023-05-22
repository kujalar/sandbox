package org.ari;

import org.ari.controller.Command;
import org.ari.controller.CommandType;
import org.ari.rmi.CommandPort;
import org.ari.rmi.ControllerTask;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static void main(String args[]) {
        // TODO tee xml parseri joka lukee filestä armeijalistan ja lataa muistiin.
        // https://www.javatpoint.com/jaxb-unmarshalling-example
        // https://www.tutorialspoint.com/java_xml/java_dom4j_parse_document.htm
        try {
            String name = "rmiCommandPort";
            Registry registry = LocateRegistry.getRegistry();
            CommandPort comp = (CommandPort) registry.lookup(name);
            ControllerTask<String,Command> stop = new ControllerTask(CommandType.STOP, null);
            String result = comp.executeTask(stop);
            System.out.println("Task was executed with result: "+result);
        } catch (Exception e) {
            System.err.println("Exception while executing the program:");
            e.printStackTrace();
        }
    }
}
