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
		String cargo = scanner.nextLine();
        String salario = scanner.nextLine();

		System.out.println("Valor inserido");
		
		saida.print(cargo + " " + salario);
		saida.flush();
	
		System.out.println("Mensagem de retorno:");
		String str = null;
		while(str == null)
		{
            str = entrada.readLine();
        }
		System.out.println(str);
	
	}
}