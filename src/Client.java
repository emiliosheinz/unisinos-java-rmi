import java.rmi.Naming;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Account account = (Account) Naming.lookup("rmi://localhost/ContaBancaria");

      Scanner scanner = new Scanner(System.in);
      int choice;
      double amount;

      do {
        System.out.println("Escolha uma operação:");
        System.out.println("1. Deposito");
        System.out.println("2. Resgate");
        System.out.println("3. Saldo");
        System.out.println("0. Sair");
        choice = scanner.nextInt();

        switch (choice) {
          case 1:
            System.out.print("Quanto você quer depositar? ");
            amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("⬆ Depósito realizado com sucesso");
            break;
          case 2:
            try {
              System.out.print("Quanto você quer resgatar? ");
              amount = scanner.nextDouble();
              account.withdraw(amount);
              System.out.println("⬇ Resgate realizado com sucesso");
              break;
            } catch (Exception e) {
              System.out.println("⚠ Erro: " + e.getMessage());
              break;
            }
          case 3:
            double balance = account.getBalance();
            System.out.println("O seu saldo é de " + balance);
            break;
          case 0:
            System.out.println("Saindo...");
            break;
          default:
            System.out.println("Opção inválida. Tente novamente!");
            break;
        }

        System.out.println();
      } while (choice != 0);

      scanner.close();
      System.out.println("Obrigado por utilizar o nosso sistema!");
    } catch (Exception e) {
      System.err.println("Erro: " + e.toString());
      e.printStackTrace();
    }
  }
}
