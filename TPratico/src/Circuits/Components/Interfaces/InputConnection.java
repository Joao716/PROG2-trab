package Circuits.Components.Interfaces;

import Circuits.Components.Component;

public interface InputConnection {
    public void addInputConnection(String pin, Component component);
    public void removeConnection(String pin, Component component);
    public void removeAllConnections();
}
