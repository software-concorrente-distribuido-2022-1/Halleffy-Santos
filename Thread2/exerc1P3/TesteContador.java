
public class TesteContador {

	public static void main(String[] args) {
		
		Contador A = new Contador("A");
		Thread threadA = new Thread(A);

		Contador B = new Contador("B");
		Thread threadB = new Thread(B);		
		
		Contador C = new Contador("C");
		Thread threadC = new Thread(C);
		
		threadA.start();
		threadB.start();
		threadC.start();
	}

}
