package Oppgave1;

import adt.MengdeADT;

public class TabellMengde<T> implements MengdeADT<T> {

	private static final int DEFAULT_KAPASITET = 10;
	private T[] tabell;
	private int antall;

	public TabellMengde() {
		this(DEFAULT_KAPASITET);
	}

	@SuppressWarnings("unchecked")
	public TabellMengde(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (tabell[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		if (annenMengde.erTom()) {
			return true;
		}
		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antall != annenMengde.antallElementer()) {
			return false;
		}

		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {

		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> nyTab = new TabellMengde<T>();
		if (annenMengde.erTom()) {
			for (int i = 0; i < antall; i++) {
				nyTab.leggTil(tabell[i]);
			}
		} else {
			for (int i = 0; i < antall; i++) {
				if (annenMengde.inneholder(tabell[i])) {
					nyTab.leggTil(tabell[i]);
				}
			}
		}
		return nyTab;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> nyTab = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			nyTab.leggTil(tabell[i]);
		}
		if (annenMengde.erTom()) {
			return nyTab;
		}

		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			if (!inneholder(annenMengde.tilTabell()[i])) {
				nyTab.leggTil(annenMengde.tilTabell()[i]);
			}
		}

		return nyTab;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> nyTab = new TabellMengde<T>();

		for (int i = 0; i < antall; i++) {
			T element = tabell[i];
			if (!annenMengde.inneholder(element)) {
				nyTab.leggTil(element);
			}
		}
		return nyTab;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			tabell[antall] = element;
			antall++;
		}

	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
			if (!inneholder(annenMengde.tilTabell()[i])) {
				tabell[antall] = annenMengde.tilTabell()[i];
				antall++;
			}
		}

	}

	@Override
	public T fjern(T element) {
		for (int i = 0; i < antall; i++) {
			if (tabell[i].equals(element)) {
				for (int j = i; j < antall - 1; j++) {
					tabell[j] = tabell[j + 1];
				}
				tabell[antall - 1] = null;
				antall--;
				return element;
			}
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] nyTab = (T[]) new Object[antall];

		for (int i = 0; i < antall; i++) {
			nyTab[i] = tabell[i];
		}

		return nyTab;

	}

	@Override
	public int antallElementer() {
		return antall;
	}

}