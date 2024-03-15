package Oppgave1;

import adt.MengdeADT;

public class HobbyMatchMain {

	public static double match(Person a, Person b) {
		MengdeADT<String> fellesHobbyer = a.getHobbyer().snitt(b.getHobbyer());
		int antallFelles = fellesHobbyer.antallElementer();
		int antallKunHosDenEne = a.getHobbyer().minus(fellesHobbyer).antallElementer();
		int antallKunHosDenAndre = b.getHobbyer().minus(fellesHobbyer).antallElementer();
		int antallTotalt = a.getHobbyer().union(b.getHobbyer()).antallElementer();

		double matchScore = (double) antallFelles
				- (double) (antallKunHosDenEne + antallKunHosDenAndre) / (double) antallTotalt;
		return matchScore;
	}

	public static void main(String[] args) {
		Person per1 = new Person("Per", "fotball", "musikk", "film");
		Person per2 = new Person("Kari", "fotball", "dans", "reiser");
		Person per3 = new Person("Ola", "programmering", "spill", "serie");

		double per1Per2Match = match(per1, per2);
		double per1Per3Match = match(per1, per3);
		double per2Per3Match = match(per2, per3);

		System.out.println("Match score mellom Per og Kari: " + per1Per2Match);
		System.out.println("Match score mellom Per og Ola: " + per1Per3Match);
		System.out.println("Match score mellom Kari og Ola: " + per2Per3Match);

		// Sjekk at match(p1, p2) gir samme score som match(p2, p1)
		assert per1Per2Match == match(per2, per1);

		// Sjekk at en person er en god match med seg selv
		Person per4 = new Person("Lisa", "lesing", "hagearbeid");
		assert match(per4, per4) == 1.0;
	}
}
