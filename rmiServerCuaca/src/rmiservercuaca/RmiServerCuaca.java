/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiservercuaca;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.ImplementasiCuaca;
/**
 *
 * @author hades
 */
public class RmiServerCuaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException,NotBoundException {
        // TODO code application logic here
        int i=1;
        Registry registry = LocateRegistry.createRegistry(1099);
        ImplementasiCuaca ic = new ImplementasiCuaca(i);
        registry.rebind("rmi",ic);
        System.out.println("server telah berjalan");
        i++;
    }
}
