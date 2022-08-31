import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		String ipHost = "10.150.160.35";
		int porta = 8080;
		Socket sock = new Socket(ipHost, porta);
		
		PrintWriter saida = new PrintWriter(sock.getOutputStream(), true);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));
		
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
        String n2 = scanner.nextLine();
        String n3 = scanner.nextLine();
        String n4 = scanner.nextLine();
        String res = n2 + " " + n3 + " " + n4;

		System.out.println("Valor inserido " + res);
		
		saida.print(res);
		saida.flush();
	
		System.out.println("Mensagem de retorno:");
		String str = null;
		while(str == null)
		{
            str = entrada.readLine();
        }

        System.out.println("-----Funcionario-------");
        System.out.println("Nome: " + n1);
        System.out.println("Nivel: " + n2);
        System.out.println("Numero de dependentes: " + n4);
        System.out.println("Salario bruto: " + n3);
        System.out.println("Salario liquido: " + str);
    }
}
	