
import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface for the Account class
public interface Account extends Remote {
  void deposit(double amount) throws RemoteException;

  void withdraw(double amount) throws RemoteException;

  double getBalance() throws RemoteException;
}