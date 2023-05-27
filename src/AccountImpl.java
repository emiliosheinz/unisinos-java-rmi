import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountImpl extends UnicastRemoteObject implements Account {
  private double balance;

  public AccountImpl() throws RemoteException {
    balance = 0.0;
  }

  public void deposit(double value) throws RemoteException {
    balance += value;
  }

  public void withdraw(double value) throws RemoteException {
    if (balance >= value) {
      balance -= value;
    } else {
      throw new RemoteException("Saldo insuficiente");
    }
  }

  public double getBalance() throws RemoteException {
    return balance;
  }
}