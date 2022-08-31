
public class ControladorAcesso {
	private boolean ocupado = false;
	private Deposito dep;
	
	ControladorAcesso(Deposito dep)
	{
		this.dep = dep;
	}
	
	public synchronized void request()
	{
		while(ocupado)
		{
			try
			{
				wait();
			}
			catch(Exception e) { }
		}
			
		ocupado = true;
	}
	
	public synchronized void release()
	{
		ocupado = false;
		notifyAll();
	}
	
	public void retiraRecurso()
	{
		dep.retirar();
	}
	
	public void colocarRecurso()
	{
		dep.colocar();
	}
}
