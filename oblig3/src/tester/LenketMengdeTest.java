package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave1.LenketMengde;
import adt.MengdeADT;

class LenketMengdeTest {

	MengdeADT<Integer> lenke = new LenketMengde<>();
	MengdeADT<Integer> lenke2 = new LenketMengde<>();

	@BeforeEach
	void leggTil() {
		lenke.leggTil(1);
		lenke.leggTil(2);
		lenke.leggTil(3);
		lenke.leggTil(4);
		lenke.leggTil(5);
		lenke2.leggTil(1);
		lenke2.leggTil(2);
		lenke2.leggTil(3);
		lenke2.leggTil(4);
		lenke2.leggTil(5);
	}

	@Test
	void testAntallElementer() {
		assertEquals(5, lenke.antallElementer());
		assertFalse(lenke.antallElementer() == 6);
		lenke.fjern(5);
		assertEquals(4, lenke.antallElementer());
	}

	@Test
	void TestInneholderLeggTil() {
		assertTrue(lenke.inneholder(1));
		assertFalse(lenke.inneholder(6));
	}

	@Test
	void TestFjern() {
		lenke.fjern(5);
		assertFalse(lenke.inneholder(5));
	}

	@Test
	void testErTom() {
		assertFalse(lenke.erTom());
		lenke.fjern(1);
		lenke.fjern(2);
		lenke.fjern(3);
		lenke.fjern(4);
		lenke.fjern(5);
		assertTrue(lenke.erTom());
	}

	@Test
	void testErDelmengdeAv() {
		lenke.fjern(5);
		assertFalse(lenke2.erDelmengdeAv(lenke));
		assertTrue(lenke.erDelmengdeAv(lenke2));
	}

	@Test
	void testErLik() {
		assertTrue(lenke.erLik(lenke2));
		lenke.fjern(1);
		assertFalse(lenke.erLik(lenke2));
	}

	@Test
	void testErDisjunkt() {
		assertFalse(lenke.erDisjunkt(lenke2));
		MengdeADT<Integer> lenke3 = new LenketMengde<>();
		lenke3.leggTil(6);
		lenke3.leggTil(7);
		lenke3.leggTil(8);
		lenke3.leggTil(9);
		lenke3.leggTil(10);
		assertTrue(lenke.erDisjunkt(lenke3));
	}

	@Test
	void testTilTabell() {
		Integer[] tabell = { 5, 4, 3, 2, 1 };
		assertArrayEquals(tabell, lenke.tilTabell());
	}

	@Test
	void testSnitt() {
	    MengdeADT<Integer> lenke3 = new LenketMengde<>();
	    lenke3.leggTil(2);
	    lenke3.leggTil(1);

	    lenke.fjern(5);
	    lenke.fjern(3);
	    lenke.fjern(4);

	    assertArrayEquals(lenke3.tilTabell(), lenke.snitt(lenke2).tilTabell());
	}

	@Test
	void testUnion() {
		Integer[] tabell = { 1, 2, 3, 4, 5, 6 };
		lenke.leggTil(6);
		assertArrayEquals(tabell, lenke.union(lenke2).tilTabell());
	}

	@Test
	void testMinus() {
		lenke2.fjern(5);
		Integer[] tabell = { 5 };
		assertArrayEquals(tabell, lenke.minus(lenke2).tilTabell());
	}
}
