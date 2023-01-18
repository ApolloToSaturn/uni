
public class Artikel {
	
	String name;
	double preis;
	int anzahl;
	int menge = 0;
	
	public Artikel(String name, double preis, int anzahl) {
		this.name = name;
		this.preis = preis;
		this.anzahl = anzahl;
		
	}
	
	public double getPreis() {
		return this.preis;
	}
	
	public int getAnzahl() {
		return anzahl;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMenge() {
		return this.menge;
	}
	
	public String setName(String name) {
		return this.name = name;
	}
	
	public int setAnzahl(int anzahl) {
		return this.anzahl = anzahl;
	}
	
	public double setPreis(double preis) {
		return this.preis = preis;
	}
	
}
