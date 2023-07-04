package org.ari;

import com.beust.jcommander.JCommander;
import org.ari.client.ClientArgs;
import org.ari.client.CommandParser;
import org.ari.controller.Command;
import org.ari.rmi.CommandPort;
import org.ari.rmi.ControllerTask;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * implemented arguments (commands):
 *      -c stop     calls shutdown to rmi-server.
 */
public class ClientMain {
    /**
     * Task implemented:
     * CommanType.STOP - sulkee main palvelun.
     *
     * @param args
     */
    public static void main(String args[]) {
        // TODO tee xml parseri joka lukee filestä armeijalistan ja lataa muistiin.
        // https://www.javatpoint.com/jaxb-unmarshalling-example
        // https://www.tutorialspoint.com/java_xml/java_dom4j_parse_document.htm

        // TODO tee clienttiin parseri, joka osaa rakentaa luetusta komentoparametrista ControllerTaskin mikä saadaan
        // lähetettyä Main metodille joka voi suorittaa suorituksensa.
        try {

            //JCommander documentation, http://jcommander.org/
            ClientArgs clientArgs = new ClientArgs();
            JCommander.newBuilder().addObject(clientArgs).build().parse(args);

            System.out.println("ClientArg: "+clientArgs.toString());

            CommandParser commandParser = new CommandParser();
            Command command = commandParser.createCommand(clientArgs);
            ControllerTask<String,Command> stop = new ControllerTask(command);

            //fetch rmi command port
            String name = "rmiCommandPort";
            Registry registry = LocateRegistry.getRegistry();
            CommandPort comp = (CommandPort) registry.lookup(name);

            //send the command to server via rmi
            String result = comp.executeTask(stop);
            System.out.println("Task was executed with result: "+result);
        } catch (Exception e) {
            System.err.println("Exception while executing the program:");
            e.printStackTrace();
        }
    }
}
