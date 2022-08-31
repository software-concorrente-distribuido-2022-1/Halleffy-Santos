 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ReajusteSalarial implements Runnable {

    private Socket clientSocket;
    
    public ReajusteSalarial(Socket cs)
    {
        clientSocket = cs;
    }

    @Override
    public void run() {
        try {
            PrintWriter saida = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String mensagem = entrada.readLine();

            String args[] = {"", ""};
            int ind = 0;
            for(int i = 0; i < mensagem.length(); i++)
            {
                if(mensagem.charAt(i) == ' ')
                {
                    ind++;
                    continue;
                }

                args[ind] += mensagem.charAt(i);
            }

            String cargo = args[0];
            Double salario = Double.parseDouble(args[1]);

            if(cargo.equals("Operador"))
            {
            	System.out.println("Op " + salario.toString());
                salario *= 1.2;
                saida.println(salario.toString());
            }
            else if (cargo.equals("Programador"))
            {
            	System.out.println("Pro " + salario.toString());
                salario *= 1.18;
                saida.println(salario.toString());
            }
            else
            {
                saida.println("Cargo inserido invalido. " + cargo);
            }

            entrada.close();
            saida.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Erro de execucao.");
        }   
    }
    
}
