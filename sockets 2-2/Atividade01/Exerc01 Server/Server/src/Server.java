import java.io.*;

public class Server extends ServerConfig {

    private Server() throws IOException {
        super();
    }

    public static void main(String args[]) throws IOException
    {
        IServer server = new Server();
        System.out.println("Server iniciado.");

        while(true)
        {
            var clientSocket = server.GetServerSockect().accept(); 
            new Thread(new ReajusteSalarial(clientSocket)).start();
        }
    }
    
}
