
public class Produtor implements Runnable {
	
	private Deposito dep;
	private int intervaloEmMilisegundos;
	
	Produtor(Deposito dep, int intervaloEmSegundos)
	{
		this.dep = dep;
		this.intervaloEmMilisegundos = intervaloEmSegundos*1000;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
		
			dep.colocar();
			System.out.println("Item colocado");
		
			try {
				Thread.sleep(intervaloEmMilisegundos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
