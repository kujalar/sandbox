package org.ari.client;

import org.ari.controller.Command;
import org.ari.controller.CommandType;

public class CommandParser {
    public Command createCommand(ClientArgs clientArgs) {
        CommandType commandType = CommandType.valueOf(clientArgs.getParamCommand().toUpperCase());
        Command command = new Command(commandType);
        return command;
    }
}
