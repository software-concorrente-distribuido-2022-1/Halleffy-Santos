
public class Consumidor implements Runnable {
	private Deposito dep;
	private int intervaloEmMilisegundos;
	
	Consumidor(Deposito dep, int intervaloEmSegundos)
	{
		this.dep = dep;
		this.intervaloEmMilisegundos = intervaloEmSegundos*1000;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			dep.retirar();
			System.out.println("Item retirado");
			
			try {
				Thread.sleep(intervaloEmMilisegundos);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
