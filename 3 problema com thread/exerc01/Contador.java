import java.util.TimerTask;

public class Contador extends TimerTask {
	@Override
	public void run()
	{
		for(int i = 0; i <= 100; i++)
		{
			System.out.println("Contador: " + i);
		}
	}
}
