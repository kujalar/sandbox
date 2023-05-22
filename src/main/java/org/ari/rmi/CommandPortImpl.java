package org.ari.rmi;

import org.ari.controller.Command;
import org.ari.controller.CommandType;
import org.ari.controller.Controller;

import java.rmi.RemoteException;

public class CommandPortImpl<T,U> implements CommandPort {
    private Controller controller = null;

    public CommandPortImpl(Controller controller) {
        super();
        this.controller = controller;
    }

/*
    public T executeTask(ControllerTask<T,U> task) {
        if (task instanceof ControllerTask) {
            ControllerTask controllerTask = (ControllerTask) task;
            CommandType commandType = controllerTask.getCommandType();
            controllerTask.setResult(controller.execute(commandType));
        }
        return task.execute();
    }*/

    @Override
    public <T, U extends Command> T executeTask(ControllerTask<T, U> task) throws RemoteException {
        if (task instanceof ControllerTask) {
            ControllerTask controllerTask = (ControllerTask<T,U>) task;
            CommandType commandType = controllerTask.getCommandType();
            Command command = controllerTask.getCommand();
            controllerTask.setResult(controller.execute(commandType, command));
        }
        return task.execute();
    }
}
