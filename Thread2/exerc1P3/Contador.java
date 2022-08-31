
public class Contador implements Runnable {
	
	private String nome;
	
	Contador(String nome)
	{
		this.nome = nome;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i <= 10; i++)
			System.out.println(nome + " " + i);
	}
}
