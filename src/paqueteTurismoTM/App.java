package paqueteTurismoTM;
import java.io.IOException;
import java.util.*;
public class App {

	public static void main(String[] args) throws IOException {
		LectorDeFicheros lector = new LectorDeFicheros();
		ArrayList<Cliente> clientes = lector.cargarClientes();
		for(Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		
		/* Para probar el nuevo metodo responderPregunta()
		 * escribir por consola una respuesta
		 * Eowyn tiene hasta 3 intentos para contestar correctamente
		 * sino, se rechaza la oferta automaticamente por boba
		 */
		System.out.println("\n El booleando retornado es: " + clientes.get(0).responderPregunta());
	}

}
