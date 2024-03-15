package Oppgave1;

public class Person {
	private String navn;
	private TabellMengde<String> hobbyer;

	public Person(String navn, String... hobbyer) {
		this.navn = navn;
		this.hobbyer = new TabellMengde<>();
		for (String hobby : hobbyer) {
			this.hobbyer.leggTil(hobby);
		}
	}

	public String getNavn() {
		return navn;
	}

	public TabellMengde<String> getHobbyer() {
		return hobbyer;
	}
}
