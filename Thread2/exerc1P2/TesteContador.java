
public class TesteContador {

	public static void main(String[] args) {
		
		Contador A = new Contador();
		Thread threadA = new Thread(A);
		threadA.start();
	}

}
