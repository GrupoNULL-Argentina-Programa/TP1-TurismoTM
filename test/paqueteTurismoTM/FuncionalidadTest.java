package paqueteTurismoTM;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FuncionalidadTest {
	LectorDeFicheros lector = new LectorDeFicheros();	
	ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
	
	@Before
	public void setup() {
		ofertas.addAll(lector.cargarPromocionAbsoluta());
		ofertas.addAll(lector.cargarPromocionAxB());
		ofertas.addAll(lector.cargarPromocionPorcentual());
	}
	@Test
	public void pruebaGetCosto() {
		assertEquals(36, ofertas.get(0).getCosto());
		assertEquals(15, ofertas.get(1).getCosto());
		assertEquals(10, ofertas.get(2).getCosto());
		assertEquals(35, ofertas.get(3).getCosto());
		assertEquals(22, ofertas.get(4).getCosto());
		assertEquals(17, ofertas.get(5).getCosto());
	}
	@Test
	public void pruebaGetTiempo() {
		assertEquals(7.5, ofertas.get(0).getTiempo(), 0);
		assertEquals(5.5, ofertas.get(1).getTiempo(), 0);
		assertEquals(7.5, ofertas.get(2).getTiempo(), 0);
		assertEquals(9.0, ofertas.get(3).getTiempo(), 0);
		assertEquals(7.0, ofertas.get(4).getTiempo(), 0);
		assertEquals(7.0, ofertas.get(5).getTiempo(), 0);
	}

}
