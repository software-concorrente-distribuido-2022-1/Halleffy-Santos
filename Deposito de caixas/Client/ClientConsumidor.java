import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ClientConsumidor implements Runnable {
	public static void main(String args[]) throws UnknownHostException, IOException
	{
		String ipHost = "192.168.0.113";
		int porta = 8080;
	
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			String input = scanner.nextLine();
		
			// if(input.equals("x"))
			// {
			// 	client.close();
			// 	return;
			// }
			
			int qtdConsumidores = Integer.parseInt(input);
			while(qtdConsumidores > 0)
			{
				Socket client = new Socket(ipHost, porta);
				new Thread(new ClientConsumidor(client)).start();
				qtdConsumidores--;
			}
		}

	}

	private Socket clientSocket;

	public ClientConsumidor(Socket sock)
	{
		clientSocket = sock;
	}

	@Override
	public void run() {

		try {
			
			PrintWriter saida = new PrintWriter(clientSocket.getOutputStream());
			BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			System.out.println("Consumidor enviado.");
			saida.print("consumidor");

			saida.close();
			entrada.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
