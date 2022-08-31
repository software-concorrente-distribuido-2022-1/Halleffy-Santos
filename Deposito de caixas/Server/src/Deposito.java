import java.io.*;
import java.net.*;

public class Deposito {
	private int items=0;
	
	private final int capacidade=10;
	
	public synchronized int retirar() {
		if (items>0) 
		{
			items--;
			System.out.println("Caixa retirada: Sobram "+items+" caixas");
			return 1; 
		}
	
		System.out.println("Nao ha itens para serem retirados.");
		return 0;
	}
	
	public synchronized int colocar () {
		if (items<capacidade) 
		{
			items++;
			System.out.println("Caixa armazenada: Passaram a ser "+items+"caixas");
			return 1; 
		}
		
		System.out.println("Capacidade máxima atingida.");
		return 0;
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Deposito dep = new Deposito();
		ControladorAcesso controlaAcesso = new ControladorAcesso(dep);
		
		int porta = 8080;
		int backlog = 5;
		ServerSocket serverSocket = new ServerSocket(porta, backlog);
		
		System.out.println("Server criado");
		
		while(true)
		{
			Socket clientSocket = serverSocket.accept();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
			String tipo = entrada.readLine();
			while(tipo == null)
			{
				tipo = entrada.readLine();
			}
			
			if(tipo.equals("produtor"))
			{
				new Thread(new Produtor(controlaAcesso, 1)).start();
			}
			
			else if(tipo.equals("consumidor"))
			{
				new Thread(new Consumidor(controlaAcesso, 1)).start();
			}
		}
		
	}
}
