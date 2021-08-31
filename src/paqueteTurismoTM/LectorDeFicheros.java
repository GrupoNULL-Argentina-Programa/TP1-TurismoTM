package paqueteTurismoTM;

import java.util.*;
import java.io.*;

public class LectorDeFicheros {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

//	public String[] leerFichero(String directorio) {
//
//		String[] arrayLineas = new String[100];
//		int cantidadLineas = 1;
//		try {
//			archivo = new File(directorio);
//			fr = new FileReader(archivo);
//			br = new BufferedReader(fr);
//			String linea;
//			linea = br.readLine();
//			while (linea != null) {
//				arrayLineas[cantidadLineas - 1] = linea;
//				cantidadLineas++;
//				linea = br.readLine();
//			}
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		} finally {
//			try {
//				if (fr != null) {
//					fr.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		arrayLineas = Arrays.copyOf(arrayLineas, cantidadLineas - 1);
//		return arrayLineas;
//	}

//	public Cliente[] cargarUsuarios() {
//		String[] arrayDeUsuarios = leerFichero("usuarios.csv");
//		Cliente[] usuarios = new Cliente[arrayDeUsuarios.length];
//		for (int i = 0; i < arrayDeUsuarios.length; i++) {
//			String[] campos = arrayDeUsuarios[i].split(";");
//			System.out.println(Arrays.toString(campos));
//			usuarios[i] = new Cliente();
//			usuarios[i].nombre = campos[0];
//			usuarios[i].preferencia = TipoAtraccion.valueOf(campos[1]);
//			usuarios[i].presupuesto = Integer.parseInt(campos[2]);
//			usuarios[i].tiempo = Double.parseDouble(campos[3]);
//		}
//		return usuarios;
//	}

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
			System.out.println(campos);
			clientes.add(new Cliente(campos.get(0),
					TipoAtraccion.valueOf(campos.get(1)),
					Integer.parseInt(campos.get(2)),
					Double.parseDouble(campos.get(3))));
		}
		return clientes;
	}

}
