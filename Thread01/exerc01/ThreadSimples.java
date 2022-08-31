package teste;

public class ThreadSimples implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Olá de uma thread!");
	}
}
