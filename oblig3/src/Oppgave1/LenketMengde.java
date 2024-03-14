package Oppgave1;

import adt.MengdeADT;

public class LenketMengde<T> implements MengdeADT<T> {

	// ---------------------------//

	private class Node {

		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	private Node forste;
	private int antall;

	public LenketMengde() {
		forste = null;
		antall = 0;
	}

	// ---------------------------//

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		Node temp = forste;
		while (temp != null) {
			if (temp.data.equals(element)) {
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		if (annenMengde.erTom()) {
			return true;
		}
		Node temp = forste;
		while (temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (annenMengde.erTom() && this.erTom()) {
			return true;
		}

		if (annenMengde.antallElementer() != this.antallElementer()) {
			return false;
		}

		Node temp = forste;
		while (temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		Node temp = forste;
		while (temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}
		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> nyLenke = new LenketMengde<T>();
		Node temp = forste;
		while (temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				nyLenke.leggTil(temp.data);
			}
			temp = temp.neste;
		}
		return nyLenke;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		MengdeADT<T> nyLenke = new LenketMengde<T>();

		Node temp = forste;
		while (temp != null) {
			nyLenke.leggTil(temp.data);
			temp = temp.neste;
		}

		if (annenMengde != null) {
			T[] elementer = annenMengde.tilTabell();
			for (T element : elementer) {
				nyLenke.leggTil(element);
			}
		}
		return nyLenke;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

		MengdeADT<T> nyLenke = new LenketMengde<T>();
		if (annenMengde.erTom() || this.erTom()) {
			return nyLenke;
		}

		Node temp = forste;
		while (temp != null) {
			nyLenke.leggTil(temp.data);
			temp = temp.neste;
		}

		temp = forste;
		while (temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				nyLenke.fjern(temp.data);
			}
			temp = temp.neste;
		}

		return nyLenke;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			Node nyNode = new Node(element);
			nyNode.neste = forste;
			forste = nyNode;
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		if (annenMengde != null) {

			T[] elementer = annenMengde.tilTabell();

			for (T element : elementer) {
				leggTil(element);
			}
		}
	}

	@Override
	public T fjern(T element) {
		if (erTom()) {
			return null;
		}

		T verdi = forste.data;
		forste = forste.neste;
		antall--;
		return verdi;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] tabell = (T[]) new Object[antallElementer()];

		Node temp = forste;
		int index = 0;
		while (temp != null) {
			tabell[index] = temp.data;
			temp = temp.neste;
			index++;
		}

		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}

}
