package paqueteTurismoTM;

import java.util.ArrayList;
import java.util.Collections;

public class Archivo {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Oferta> ofertas = new ArrayList<Oferta>();

	public static void OrdenarOfertas() {
		for (int i = 0; i < ofertas.size(); i++) {
			for (int j = 0; j < ofertas.size(); j++) {
				if (Archivo.ofertas.get(i).compareTo(Archivo.ofertas.get(j)) == 1) {
					Collections.swap(Archivo.ofertas, i, j);
				}
			}
		}
	}
}
