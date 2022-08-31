
public class Consumidor implements Runnable {
	private ControladorAcesso controlaAcesso;
	private int intervaloEmMilisegundos;
	
	Consumidor(ControladorAcesso dep, int intervaloEmSegundos)
	{
		this.controlaAcesso = dep;
		this.intervaloEmMilisegundos = intervaloEmSegundos*1000;
	}
	
	@Override
	public void run()
	{
		controlaAcesso.request();
		controlaAcesso.retiraRecurso();;
		System.out.println("Item retirado");
		
		try {
			Thread.sleep(intervaloEmMilisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		controlaAcesso.release();
	}
}
