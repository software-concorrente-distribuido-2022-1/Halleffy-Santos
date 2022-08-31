import java.util.Timer;

public class Exercicio01 {

	public static void main(String[] args) {
		Contador contador = new Contador();
		
		Timer timer = new Timer();
		timer.schedule(contador, 0);
		System.out.println("Programa finalizado");
	}
}
