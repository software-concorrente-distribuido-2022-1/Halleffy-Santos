
public class Produtor implements Runnable {
	
	private ControladorAcesso controlaAcesso;
	private int intervaloEmMilisegundos;
	
	Produtor(ControladorAcesso dep, int intervaloEmSegundos)
	{
		this.controlaAcesso = dep;
		this.intervaloEmMilisegundos = intervaloEmSegundos*1000;
	}
	
	@Override
	public void run()
	{
		controlaAcesso.request();
		controlaAcesso.colocarRecurso();
		System.out.println("Item colocado");
	
		try {
			Thread.sleep(intervaloEmMilisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		controlaAcesso.release();
	}
}
