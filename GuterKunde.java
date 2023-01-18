
public class GuterKunde extends Kunde {
	
	double nachlass;
	Kunde k = new Kunde(vorname, nachname);
	
	public GuterKunde(String vorname, String nachname, double nachlass) {
		super(vorname, nachname);
		if (k instanceof Kunde) {
			this.nachlass = nachlass;
		}
	}
	
	public double getNachlass() {
		return nachlass;
	}
	
}
