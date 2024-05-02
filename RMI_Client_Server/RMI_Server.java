package RMI_Client_Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements RMI_Interface {

    protected RMI_Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            // Create an RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Create a new instance of the server and bind it to the registry
            RMI_Server server = new RMI_Server();
            registry.rebind("rmi_server", server);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.err.println("RMI Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public double calculateSquareRoot(double number) throws RemoteException {
        return Math.sqrt(number);
    }
}