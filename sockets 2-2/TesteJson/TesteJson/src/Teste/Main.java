package Teste;
import org.json.simple.*;

public class Main {
	public static void main(String[] args)
	{
		JSONObject obj = new JSONObject();
		obj.put("name", "Halleffy");
		obj.put("Idade", new Integer(22));
		
		System.out.print(obj);
	}
}
