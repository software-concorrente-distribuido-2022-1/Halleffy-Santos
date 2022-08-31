import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server
{
    public static void main(String args[]) throws IOException
    {
        int porta = 8080;
        int backlog = 5;
        ServerSocket serverSocket = new ServerSocket(porta, backlog);
        System.out.println("Server criado");

        while(true)
        {
            var clientSocket = serverSocket.accept();
            new Thread(new Maioridade(clientSocket)).start();
        }
    }
}

class Maioridade implements Runnable
{
    private Socket socket;
    
    public Maioridade(Socket sc)
    {
        socket = sc;
    }

    @Override
    public void run() 
    {
        try {
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); 

            String msg = entrada.readLine();
            
            String args[] = {"", ""};
            int ind = 0;
            for(int i = 0; i < msg.length(); i++)
            {
                if(msg.charAt(i) == ' ')
                {
                    ind++;
                    continue;
                }

                args[ind] += msg.charAt(i);
            }
           
            System.out.println(args[0] + " " + args[1]);

            String sexo = args[0];
            int idade = Integer.parseInt(args[1]);

            if(sexo.equals("masculino") && idade >= 18)
            {
                saida.print("S");
            }
            else if(sexo.equals("feminino") && idade >= 21)
            {
                saida.print("S");
            }
            else
                saida.print("N");
            
            saida.close();
            entrada.close();
            socket.close();
            
        } catch (IOException e) {
            System.out.println("Erro de conexao");
        }     
    }
    
}