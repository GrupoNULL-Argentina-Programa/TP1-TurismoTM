package paqueteTurismoTM;
import java.util.*;
public class App {

	public static void main(String[] args) {
		LectorDeFicheros lector = new LectorDeFicheros();
		ArrayList<Cliente> clientes = lector.cargarClientes();
		for(Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
