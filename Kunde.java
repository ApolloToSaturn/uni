
public class Kunde {
	
	String vorname;
	String nachname;
	
	public Kunde(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public String toString() {
		return (vorname + " " + nachname);
	}
	
}
