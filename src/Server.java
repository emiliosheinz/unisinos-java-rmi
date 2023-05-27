import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
  public static void main(String[] args) {
    try {
      // Create an instance of the AccountImpl class
      Account account = new AccountImpl();

      // Register the account object as a remote object
      LocateRegistry.createRegistry(1099);

      // Bind the object instance to the name "ContaBancaria"
      Naming.rebind("ContaBancaria", account);

      System.out.println("Servidor RMI pronto");
    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}