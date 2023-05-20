package org.ari.rmi;

import org.ari.controller.CommandType;
import org.ari.controller.Controller;

public class CommandPortImpl implements CommandPort {
    private Controller controller = null;

    public CommandPortImpl(Controller controller) {
        super();
        this.controller = controller;
    }

    public <T> T executeTask(Task<T> task) {
        if (task instanceof ControllerTask) {
            ControllerTask controllerTask = (ControllerTask) task;
            CommandType commandType = controllerTask.getCommandType();
            controllerTask.setResult(controller.execute(commandType));
        }
        return task.execute();
    }
}
