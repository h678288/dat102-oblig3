package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave1.TabellMengde;

class TabellMengdeTest {

	TabellMengde<Integer> mengde = new TabellMengde<>();
	TabellMengde<Integer> mengde2 = new TabellMengde<>();
	
	
	@BeforeEach
	void leggTil() {
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		mengde.leggTil(4);
		mengde.leggTil(5);
		mengde2.leggTil(1);
		mengde2.leggTil(2);
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		mengde2.leggTil(5);
	}
	
	@Test
	void testAntallElementer() {
		assertEquals(5, mengde.antallElementer());
		assertFalse(mengde.antallElementer() == 6);
		mengde.fjern(5);
		assertEquals(4, mengde.antallElementer());
	}
	

	@Test
	void TestInneholderLeggTil() {
		assertTrue(mengde.inneholder(1));
		assertFalse(mengde.inneholder(6));
	}
	
	@Test
	void TestFjern() {
		mengde.fjern(1);
		assertFalse(mengde.inneholder(1));
	}
	
	@Test
	void testErTom() {
		assertFalse(mengde.erTom());
		mengde.fjern(1);
		mengde.fjern(2);
		mengde.fjern(3);
		mengde.fjern(4);
		mengde.fjern(5);
		assertTrue(mengde.erTom());
	}
	
	@Test
	void testErDelmengdeAv() {
		mengde.fjern(5);
		assertFalse(mengde2.erDelmengdeAv(mengde));
		assertTrue(mengde.erDelmengdeAv(mengde2));
	}
	
	@Test
	void testErLik() {
		assertTrue(mengde.erLik(mengde2));
		mengde.fjern(1);
		assertFalse(mengde.erLik(mengde2));
	}
	
	@Test
	void testErDisjunkt() {
		 assertFalse(mengde.erDisjunkt(mengde2));
		 TabellMengde<Integer> mengde3 = new TabellMengde<>();
		 mengde3.leggTil(6);
		 mengde3.leggTil(7);
		 mengde3.leggTil(8);
		 mengde3.leggTil(9);
		 mengde3.leggTil(10);
		 assertTrue(mengde.erDisjunkt(mengde3));
	}
	
	@Test
	void testTilTabell() {
		Integer[] tabell = {1,2,3,4,5};
		assertArrayEquals(tabell, mengde.tilTabell());
	}
	
	@Test
	void testSnitt() {
		TabellMengde<Integer> mengde3 = new TabellMengde<>();
		mengde3.leggTil(1);
		mengde3.leggTil(2);
	
		mengde.fjern(5);
		mengde.fjern(3);
		mengde.fjern(4);
		assertArrayEquals(mengde3.tilTabell(), mengde.snitt(mengde2).tilTabell());
	}
	
	@Test
	void testUnion() {
		Integer[] tabell = {1,2,3,4,5,6};
		mengde.leggTil(6);
		assertArrayEquals(tabell, mengde.union(mengde2).tilTabell());
	}
	
	@Test
	void testMinus() {
		mengde2.fjern(5);
		Integer[] tabell = {5};
		assertArrayEquals(tabell, mengde.minus(mengde2).tilTabell());
	}
	
}
