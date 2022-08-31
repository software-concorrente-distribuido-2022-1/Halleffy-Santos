
public class Abacate extends Thread {
	
	@Override
	public void run()
	{
		System.out.println("Abacate");
		
		try {
			Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
