package paqueteTurismoTM;

import java.util.*;

//import com.sun.tools.javac.code.Attribute.Array;

import java.io.*;

public class LectorDeFicheros {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;


	public ArrayList<String> leerFichero(String directorio) {

		ArrayList<String> arrayLineas = new ArrayList<String>();		
		
		try {
			archivo = new File(directorio);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			linea = br.readLine();
			while (linea != null) {
				arrayLineas.add(linea);
				linea = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return arrayLineas;
	}

	public ArrayList<Cliente> cargarClientes() {
		ArrayList<String> arrayDeClientes = leerFichero("res/entrada/clientes.txt");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 0; i < arrayDeClientes.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDeClientes.get(i).split(";")));
			//System.out.println(campos);
			clientes.add(new Cliente(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
					Integer.parseInt(campos.get(2)), Double.parseDouble(campos.get(3))));
		}
		return clientes;
	}

	// Estos metodos no serian responsabilidad de tierra media?
	public ArrayList<Oferta> cargarAtraccion() {
		ArrayList<String> arrayDeAtracciones = leerFichero("res/entrada/atracciones.txt");
		ArrayList<Oferta> atracciones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDeAtracciones.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDeAtracciones.get(i).split(";")));
			//System.out.println(campos);
			atracciones.add(
					new Atraccion(campos.get(0), Integer.parseInt(campos.get(1)), Double.parseDouble(campos.get(2)),
							Integer.parseInt(campos.get(3)), TipoAtraccion.valueOf(campos.get(4))));
		}
		return atracciones;
	}

	public ArrayList<Oferta> cargarPromocionAbsoluta() {
		ArrayList<String> arrayDePromAbs = leerFichero("res/entrada/promocionAbsoluta.txt");
		ArrayList<Oferta> promociones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDePromAbs.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDePromAbs.get(i).split(";")));
			//System.out.println(campos);
			@SuppressWarnings("unused")
			ArrayList<String> arrayDeAtracciones;
			promociones.add(new PromocionAbsoluta(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
					Integer.parseInt(campos.get(2)),
					arrayDeAtracciones = new ArrayList<>(Arrays.asList(campos.get(3).split(",")))));
		}
		return promociones;
	}

	public void generarTicket(ArrayList<Oferta> ofertas) throws IOException{
		PrintWriter salida = new PrintWriter(new FileWriter("res/salida/ticket.txt"));
		for(Oferta oferta : ofertas) {
			salida.println(oferta);
		}
		salida.close();
	}
	
	public ArrayList<Oferta> cargarPromocionAxB() {
		ArrayList<String> arrayDePromAxB = leerFichero("res/entrada/promocionAxB.txt");
		ArrayList<Oferta> promociones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDePromAxB.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDePromAxB.get(i).split(";")));
			System.out.println(campos);
			@SuppressWarnings("unused")
			ArrayList<String> arrayDeAtraccionesPagas;
			ArrayList<String> arrayDeAtraccionesGratis;
			promociones.add(new PromocionAxB(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
					arrayDeAtraccionesPagas = new ArrayList<>(Arrays.asList(campos.get(2).split(","))),
					arrayDeAtraccionesGratis = new ArrayList<>(Arrays.asList(campos.get(3).split(",")))));

		}
		return promociones;
	}
	
	public ArrayList<Oferta> cargarPromocionPorcentual() {
		ArrayList<String> arrayDePromPorc = leerFichero("res/entrada/promocionPorcentual.txt");
		ArrayList<Oferta> promociones = new ArrayList<Oferta>();
		for (int i = 0; i < arrayDePromPorc.size(); i++) {
			ArrayList<String> campos = new ArrayList<>(Arrays.asList(arrayDePromPorc.get(i).split(";")));
			System.out.println(campos);
			@SuppressWarnings("unused")
			ArrayList<String> arrayDeAtracciones;
			promociones.add(new PromocionPorcentual(campos.get(0), TipoAtraccion.valueOf(campos.get(1)),
					Double.parseDouble(campos.get(2)),
					arrayDeAtracciones = new ArrayList<>(Arrays.asList(campos.get(3).split(",")))));

		}
		return promociones;
	}


}
