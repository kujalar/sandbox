package org.ari.rmi;

public interface Task<T,U> {
    public U getCommand();
    public T execute();
}
