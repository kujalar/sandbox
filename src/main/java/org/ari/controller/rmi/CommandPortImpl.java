package org.ari.controller.rmi;

import org.ari.controller.Controller;

public class CommandPortImpl implements CommandPort {
    private Controller controller = null;

    public CommandPortImpl(Controller controller) {
        super();
        this.controller = controller;
    }

    public <T> T executeTask(Task<T> t) {
        return controller.execute(t);
    }
}
