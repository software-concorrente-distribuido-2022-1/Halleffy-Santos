
public class Uva extends Thread {
	@Override
	public void run()
	{
		System.out.println("Uva");
		
		try {
			Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
