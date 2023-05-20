package org.ari.rmi;

import org.ari.controller.CommandType;
import org.ari.rmi.Task;

import java.io.Serializable;

public class ControllerTask implements Task<String>, Serializable {
    private static final long serialVersionUID = 227L;
    private final CommandType commandType;
    private String result = null;

    public ControllerTask(CommandType commandType) {
        this.commandType = commandType;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public CommandType getCommandType() {
        return this.commandType;
    }
    public String execute() {
        return result;
    }
}
