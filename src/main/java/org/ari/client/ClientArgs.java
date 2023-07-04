package org.ari.client;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ClientArgs {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = {"-c", "-command"}, description = "Defines a command to execute")
    private String paramCommand;

    public String getParamCommand() {
        return paramCommand;
    }

    public String toString() {
        return paramCommand;
    }
}
