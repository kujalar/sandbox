package org.ari.rmi;

import org.ari.controller.Command;
import org.ari.controller.CommandType;

import java.io.Serializable;

public class ControllerTask<T,U extends Command> implements Task<T,U>, Serializable {
    private static final long serialVersionUID = 227L;
    private T result = null;
    private U command;

    public ControllerTask(U command) {
        this.command = command;
    }
    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public T execute() {
        return result;
    }
    @Override
    public U getCommand() {
        return command;
    }
}
