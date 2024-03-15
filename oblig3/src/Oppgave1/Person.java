package Oppgave1;

public class Person {

	private String navn;
	private String[] hobbyer;
	
	public Person(String navn, String ... hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String[] getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(String[] hobbyer) {
		this.hobbyer = hobbyer;
	}	
	
}
