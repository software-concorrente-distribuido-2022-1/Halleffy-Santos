import java.io.*;
import java.net.*;

public abstract class ClientConfig implements IClient
{
    private final int portServer = 8080;
    private final String ipHost = "192.168.0.104";

    private BufferedReader entrada;
    private PrintWriter saida;

    private Socket clientSocket;

    public ClientConfig() throws UnknownHostException, IOException
    {
        clientSocket = new Socket(ipHost, portServer);
        entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        saida = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public String PostMensage(String msg)
    {
        saida.println(msg);

        try 
        {
            return entrada.readLine();
        }
        catch (IOException e) {
            return "Erro no envia da mensagem";
        }
    }

}
