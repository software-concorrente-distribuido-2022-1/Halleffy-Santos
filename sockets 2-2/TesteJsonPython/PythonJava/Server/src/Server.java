import java.io.*;
import java.net.*;


public class Server {
	public static void main(String[] args) throws IOException
	{
		int porta = 8080;
		int backlog = 5;
		
		ServerSocket serverSocket = new ServerSocket(porta, backlog);
		System.out.println("Server criado");
		
		while(true)
		{
			new Thread(new Processar(serverSocket.accept())).start();
		}
	}
}

class Processar implements Runnable
{
	private Socket clientSocket;
	
	Processar(Socket sock)
	{
		clientSocket = sock;
	}
	
	@Override
	public void run() 
	{
		String str = "Mensagem chegou ao servidor com sucesso.";
		System.out.println("Conexao Client-Server executada com sucesso");
		
		try 
		{
			OutputStreamWriter saida = new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8");
			BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String msg = entrada.readLine();
			System.out.println("Mensagem recebida: " + msg);
			
			saida.write(str, 0, str.length());
			//saida.flush();
			
			saida.close();
			entrada.close();
			clientSocket.close();
			
		} catch(Exception e)
		{
			
		}
	}
	
}
