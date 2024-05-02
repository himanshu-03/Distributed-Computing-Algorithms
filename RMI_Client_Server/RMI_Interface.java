package RMI_Client_Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_Interface extends Remote {
    double calculateSquareRoot(double number) throws RemoteException;
}