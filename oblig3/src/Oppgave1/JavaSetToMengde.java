package Oppgave1;

import java.util.HashSet;
import java.util.Set;

import adt.MengdeADT;

public class JavaSetToMengde<T>implements MengdeADT<T> {

	private Set<T> set;
	
	public JavaSetToMengde() {
		set = new HashSet<>();
	}

	@Override
	public boolean erTom() {
		return set.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return set.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if(annenMengde == null || antallElementer() != annenMengde.antallElementer()) {
			return false;
		}
		
		for (T t : set) {
			if(!annenMengde.inneholder(t)) {
				return false;
			}
		}
		return true;
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
		set.add(element);
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		if(annenMengde != null) {
			T[] elementer = annenMengde.tilTabell();
			for (T t : elementer) {
				set.add(t);
			}
		}
	}

	@Override
	public T fjern(T element) {
		set.remove(element);
		return element;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] tabell = (T[]) new Object[antallElementer()];
		int index = 0;
		for (T t : set) {
			tabell[index] = t;
			index++;
		}
		return tabell;
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

	
	
}
