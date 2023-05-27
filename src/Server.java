import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
  public static void main(String[] args) {
    try {
      Account account = new AccountImpl();

      LocateRegistry.createRegistry(1099);

      Naming.rebind("ContaBancaria", account);

      System.out.println("Servidor RMI pronto");
    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}