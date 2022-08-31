import java.io.*;
import java.net.*;
import java.util.*;

public class Client extends ClientConfig 
{
    public Client() throws UnknownHostException, IOException {
        super();
    }

    public static void main(String args[]) throws UnknownHostException, IOException
    {
        IClient client = new Client();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome, o cargo e o salario do funcionario.");
        
        String nome = scanner.nextLine();
        String cargo = scanner.nextLine();
        String salario = scanner.nextLine();

        System.out.println("--------Funcionario------------");
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);
        System.out.println("Salario reajustado: " + client.PostMensage(cargo + " " + salario));

        scanner.close();
    }
    
}