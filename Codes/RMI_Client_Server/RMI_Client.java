package RMI_Client_Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_Client {

    public static void main(String[] args) {
        try {
            // Get the remote object reference from the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMI_Interface stub = (RMI_Interface) registry.lookup("rmi_server");

            // Call the remote method
            double number = 25.0;
            double result = stub.calculateSquareRoot(number);
            System.out.println("Square root of " + number + " is: " + result);

            // Keep the client program running
            System.out.println("Client program will now keep running. Press Ctrl+C to exit.");
            while (true) {
                Thread.sleep(1000); // Sleep for 1 second (optional)
            }
        } catch (Exception e) {
            System.err.println("RMI Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}