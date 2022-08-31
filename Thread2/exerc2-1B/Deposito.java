
public class Deposito {
	private int items=0;
	
	private final int capacidade=10;
	
	public int retirar() {
		if (items>0) 
		{
			items--;
			System.out.println("Caixa retirada: Sobram "+items+" caixas");
			return 1; 
		}
	
		return 0;
	}
	
	public int colocar () {
		if (items<capacidade) 
		{
			items++;
			System.out.println("Caixa armazenada: Passaram a ser "+items+"caixas");
			return 1; 
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Deposito dep = new Deposito();
		Produtor p = new Produtor(dep, 2);
		Consumidor c = new Consumidor(dep, 3);
		
		Thread threadProdutor = new Thread(p);
		Thread threadConsumidor = new Thread(c);
		
		threadProdutor.start();
		threadConsumidor.start();
		
		//UNIVERSIDADE FEDERAL DE GOIÁS
		//INSTITUTO DE INFORMÁTICA
		//Prof. Sérgio Teixeira de Carvalho
		System.out.println("Execução do main da classe Deposito terminada!");
	}
}
