package org.ari.rmi;

import org.ari.controller.Command;
import org.ari.controller.CommandType;
import org.ari.rmi.Task;

import java.io.Serializable;

public class ControllerTask<T,U extends Command> implements Task<T,U>, Serializable {
    private static final long serialVersionUID = 227L;
    private final CommandType commandType;
    private T result = null;
    private U command;

    public ControllerTask(CommandType commandType, U command) {
        this.commandType = commandType;
    }
    public void setResult(T result) {
        this.result = result;
    }

    public CommandType getCommandType() {
        return this.commandType;
    }
    @Override
    public T execute() {
        return result;
    }
    @Override
    public U getCommand() {
        return null;
    }
}
