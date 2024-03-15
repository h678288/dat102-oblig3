package Oppgave2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Sammenligning {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		int[] tab = new int[100000];

		int tall = 376; // Her kan vi bruke eit vilkårleg tal
		for (int i = 0; i < 100000; i++) {
			set.add(tall);
			tab[i] = tall;
			tall = (tall + 45713) % 1000000; // Sjå nedanfor om 45713
		}

		Arrays.sort(tab);

		Random r = new Random(10000);
		int[] nyTab = new int[100000];
		for (int i = 0; i < nyTab.length; i++) {
			nyTab[i] = r.nextInt(1000000);
		}
		int antHash = 0;
		int antTab = 0;

		long startTidHash = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			int ranTall = nyTab[i];
			if (set.contains(ranTall)) {
				antHash++;
			}
		}
		long sluttTidHash = System.nanoTime();
		long tidHash = sluttTidHash - startTidHash;

		long startTidTab = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			int ranTall = nyTab[i];
			if (Arrays.binarySearch(tab, ranTall) >= 0) {
				antTab++;
			}
		}
		long sluttTidTab = System.nanoTime();
		long tidTab = sluttTidTab - startTidTab;

		System.out.println("Antall funnet i HashSet: " + antHash + "\nTid: " + tidHash + " nanosekund");
		System.out.println();
		System.out.println("Antall funnet ved binærsøk: " + antTab + "\nTid: " + tidTab + " nanosekund");
	}

}
