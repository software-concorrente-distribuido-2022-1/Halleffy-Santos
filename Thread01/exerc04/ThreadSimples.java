package teste;

public class ThreadSimples 
{
	//Método responsável por retornar o nome da Thread e a menssagem concatenadas
	static void mensagem(String messagem) {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + " " + messagem);
	}
	
	//Implementa a interface Runnable para criação da Thread posteriormente
	private static class Loop implements Runnable {
		//Método que será executado pela Thread no processador
		public void run() 
		{
			String info[] = {
			"Java",
			"é uma boa linguagem.",
			"Com threads,",
			"é melhor ainda."
			};
			
			//Realiza a operação abaixo
			try {
				for (int i = 0; i < info.length; i++) {
					Thread.sleep(4000);
					mensagem(info[i]);
				}
			//caso seja haja uma enterrupção na Thread atual, excessão é tratada.
			} catch (InterruptedException e) {
				mensagem("Nada feito!");
			}
		}
	}
			
	//Thread main, inicial a aplicação.
	public static void main(String args[]) throws InterruptedException
	{
		//lida com o argumento passado à main.
		long paciencia = 1000 * 60 * 60;
		if (args.length > 0) 
		{
			try 
			{
				paciencia = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argumento deve ser um inteiro.");
				System.exit(1);
			}
		}
		
		mensagem("Iniciando a thread Loop");
		
		long inicio = System.currentTimeMillis();
		
		//Cria-se a Thread a partir da implementação da interface Runnable
		//Estado Born
		Thread t = new Thread(new Loop());
		
		//Thread t vai ao estado ready, pronta para ser executado pela CPU
		t.start();
		
		mensagem("Esperando que a thread Loop termine");
		
		//Looping que verifica se a Thread t está em ready, pronta a execução.
		while (t.isAlive()) 
		{
			mensagem("Ainda esperando...");
			
			//faz com a Thread main, atual, espera a t por mais um tempo.
			t.join(1000);
			
			if (((System.currentTimeMillis() - inicio) > paciencia) && t.isAlive()) 
			{
				mensagem("Cansado de esperar!");
				//caso o tempo de espera informado no argumento tenha passado, interrompe a t e espera essa encerrar;
				t.interrupt();
				t.join();
			}
		}
		
		//Nesse instante a Thread t foi finalizada e a main continuará.
		mensagem("Finalmente!");
	}
}