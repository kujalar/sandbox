package org.ari.controller.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CommandPort extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
