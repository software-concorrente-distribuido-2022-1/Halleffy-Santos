import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String args[]) throws UnknownHostException, IOException
    {   
        String ipHost = null;
        int porta = 8080;
        Socket clientSocket = new Socket(ipHost, porta);

        PrintWriter saida = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Digite o nome, o sexo e a idade da pessoa.");

        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String sexo = scanner.nextLine();
        String idade = scanner.nextLine();

        saida.println(sexo + " " + idade);
        String resposta = entrada.readLine();

        System.out.print(nome + " do sexo " + sexo + " com " + idade + " anos");
        
        System.out.print((resposta.equals("S")) ? "" : " nao");
        System.out.print(" atingiu a maioridade");

        scanner.close();
        clientSocket.close();
    }
}