package br.edu.insper.desagil.alfandega;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlfandegaTest {
	private static double DELTA = 0.01;

	private Alfandega alfandega;

	@BeforeEach
	void setUp() {
		alfandega = new Alfandega();
	}

	@Test
	void testA() {
		alfandega.declara(new Item("a", 25.0, 5.12));
		alfandega.declara(new Item("b", 50.0, 6.19));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(4.38, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testB() {
		alfandega.declara(new Item("a", 50.0, 5.12));
		alfandega.declara(new Item("b", 25.0, 6.19));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(4.11, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testC() {
		alfandega.declara(new Item("a", 25.0, 5.12));
		alfandega.declara(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(186.98, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testD() {
		alfandega.declara(new Item("a", 50.0, 5.12));
		alfandega.declara(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(95.41, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testE() {
		alfandega.declara(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declara(new Item("b", 50.0, 6.19));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(79.9, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testF() {
		alfandega.declara(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declara(new Item("b", 25.0, 6.19));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(155.15, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testG() {
		alfandega.declara(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declara(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(262.5, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testH() {
		alfandega.declara(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declara(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(246.45, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testI() {
		alfandega.declara(new ItemTarifado("a", 25.0, 5.12, 0.8));
		alfandega.declara(new ItemTarifado("b", 50.0, 6.19, 0.8));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(350.0, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testJ() {
		alfandega.declara(new ItemTarifado("a", 50.0, 5.12, 0.8));
		alfandega.declara(new ItemTarifado("b", 25.0, 6.19, 0.8));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(328.6, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testK() {
		alfandega.declara(new ItemTarifado("a", 25.0, 5.12, 0.6));
		alfandega.declara(new ItemTarifado("b", 50.0, 6.19, 0.8));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(324.4, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testL() {
		alfandega.declara(new ItemTarifado("a", 50.0, 5.12, 0.6));
		alfandega.declara(new ItemTarifado("b", 25.0, 6.19, 0.8));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(277.4, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testM() {
		alfandega.declara(new ItemTarifado("a", 25.0, 5.12, 0.8));
		alfandega.declara(new ItemTarifado("b", 50.0, 6.19, 0.6));
		assertEquals(437.5, alfandega.getTotal(false), DELTA);
		assertEquals(288.1, alfandega.getTotal(true), DELTA);
	}

	@Test
	void testN() {
		alfandega.declara(new ItemTarifado("a", 50.0, 5.12, 0.8));
		alfandega.declara(new ItemTarifado("b", 25.0, 6.19, 0.6));
		assertEquals(410.75, alfandega.getTotal(false), DELTA);
		assertEquals(297.65, alfandega.getTotal(true), DELTA);
	}
}
