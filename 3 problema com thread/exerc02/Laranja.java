
public class Laranja extends Thread{
	@Override
	public void run()
	{
		System.out.println("Laranja");
		
		try {
			Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
