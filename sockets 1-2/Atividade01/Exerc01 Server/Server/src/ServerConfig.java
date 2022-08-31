import java.io.*;
import java.net.*;

public abstract class ServerConfig implements IServer
{
    private final int portaServer = 8080;
    private final int backlog = 5;
    private ServerSocket socketServer;

    protected ServerConfig() throws IOException
    {
        socketServer = new ServerSocket(portaServer, backlog);
    }

    public ServerSocket GetServerSockect()
    {
        try {
            return socketServer = (socketServer != null) ? socketServer : new ServerSocket();
        } 
        catch (IOException e) {
            System.out.println("Erro na criacao do server.");
        }
        return null;
    }
}
