package org.ari.rmi;

import org.ari.controller.Command;
import org.ari.controller.Controller;

import java.rmi.RemoteException;

public class CommandPortImpl<T,U> implements CommandPort {
    private Controller controller = null;

    public CommandPortImpl(Controller controller) {
        super();
        this.controller = controller;
    }

    @Override
    public <T, U extends Command> T executeTask(ControllerTask<T, U> task) throws RemoteException {
        if (task instanceof ControllerTask) {
            ControllerTask controllerTask = (ControllerTask<T,U>) task;
            Command command = controllerTask.getCommand();
            controllerTask.setResult(controller.execute(command));
        }
        return task.execute();
    }
}
