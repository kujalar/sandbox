package org.ari.rmi;

import org.ari.controller.Command;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CommandPort extends Remote {
    <T,U extends Command> T executeTask(ControllerTask<T, U> t) throws RemoteException;
}
