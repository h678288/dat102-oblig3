package Oppgave1;

import adt.MengdeADT;



public class LenketMengde<T> implements MengdeADT<T>{

	//---------------------------//
	
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

	//---------------------------//
	
	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		Node temp = forste;
		while(temp != null) {
			if(temp.data.equals(element)) {
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTil(T element) {
		if(!inneholder(element)) {
			Node nyNode = new Node(element);
			nyNode.neste = forste;
			forste = nyNode;
			antall++;
		}
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		if(annenMengde != null) {
			
			T[] elementer = annenMengde.tilTabell();
			
			for(T element : elementer) {
				leggTil(element);
			}
		}
	}

	@Override
	public T fjern(T element) {
		if(erTom()) {
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
		while(temp != null) {
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
