package org.ari.controller;

import java.io.Serial;
import java.io.Serializable;

//TODO convert to a record - like warning says this class could be?
public class Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 227L;
    private final CommandType commandType;
    public Command(CommandType commandType){
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }
}
