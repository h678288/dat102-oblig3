package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave1.JavaSetToMengde;
import Oppgave1.LenketMengde;
import adt.MengdeADT;

class JavaSetToMengdeTest {

	MengdeADT<Integer> set = new JavaSetToMengde<>();
	MengdeADT<Integer> set2 = new JavaSetToMengde<>();
	
	
	@BeforeEach
	void leggTil() {
		set.leggTil(1);
		set.leggTil(2);
		set.leggTil(3);
		set.leggTil(4);
		set.leggTil(5);
		set2.leggTil(1);
		set2.leggTil(2);
		set2.leggTil(3);
		set2.leggTil(4);
		set2.leggTil(5);
	}
	
	@Test
	void testAntallElementer() {
		assertEquals(5, set.antallElementer());
		assertFalse(set.antallElementer() == 6);
		set.fjern(5);
		assertEquals(4, set.antallElementer());
	}
	
	@Test
	void TestInneholderLeggTil() {
		assertTrue(set.inneholder(1));
		assertFalse(set.inneholder(6));
	}
	
	@Test
	void TestFjern() {
		set.fjern(1);
		assertFalse(set.inneholder(1));
	}
	
	@Test
	void testErTom() {
		assertFalse(set.erTom());
		set.fjern(1);
		set.fjern(2);
		set.fjern(3);
		set.fjern(4);
		set.fjern(5);
		assertTrue(set.erTom());
	}
	
	@Test
	void testErDelmengdeAv() {
		set.fjern(5);
		assertFalse(set2.erDelmengdeAv(set));
		assertTrue(set.erDelmengdeAv(set2));
	}
	
	@Test
	void testErLik() {
		assertTrue(set.erLik(set2));
		set.fjern(1);
		assertFalse(set.erLik(set2));
	}
	
	@Test
	void testErDisjunkt() {
		 assertFalse(set.erDisjunkt(set2));
		 MengdeADT<Integer> set3 = new JavaSetToMengde<>();
		 set3.leggTil(6);
		 set3.leggTil(7);
		 set3.leggTil(8);
		 set3.leggTil(9);
		 set3.leggTil(10);
		 assertTrue(set.erDisjunkt(set3));
	}
	
	@Test
	void testTilTabell() {
		Integer[] tabell = {1,2,3,4,5};
		assertArrayEquals(tabell, set.tilTabell());
	}
	
	@Test
	void testSnitt() {
		MengdeADT<Integer> set3 = new JavaSetToMengde<>();
		set3.leggTil(1);
		set3.leggTil(2);
	
		set.fjern(5);
		set.fjern(3);
		set.fjern(4);
		assertArrayEquals(set3.tilTabell(), set.snitt(set2).tilTabell());
	}
	
	@Test
	void testUnion() {
		Integer[] tabell = {1,2,3,4,5,6};
		set.leggTil(6);
		assertArrayEquals(tabell, set.union(set2).tilTabell());
	}
	
	@Test
	void testMinus() {
		set2.fjern(5);
		Integer[] tabell = {5};
		assertArrayEquals(tabell, set.minus(set2).tilTabell());
	}

}
