
public class WebShop {
	
	Kunde[] kunden;
	Artikel[] items;
//	String[] artikel;

	int mengeArtikel;
	int mengeKunden;
	
	public WebShop() {
		kunden = new Kunde[10];
		items = new Artikel[10];
	}
	
	void neuerArtikel(String name, double preis, int anzahl) {
		
		items[mengeArtikel] = new Artikel(name, preis, anzahl);
		this.mengeArtikel++;
	}
	
	Kunde neuerKunde(String vorname, String nachname) {
	
		Kunde kunde = new Kunde(vorname, nachname);
		return kunde;
	}
	Kunde neuerKunde(String vorname, String nachname, double nachlass) {
		
		GuterKunde kunde = new GuterKunde(vorname, nachname, nachlass);
		return kunde;
	}	
	
	Artikel sucheArtikel(String name) {
		Artikel gesucht = null;
		for (int i=0;i<items.length;i++) {
			if (items[i] != null && items[i].getName().equals(name)) {
				gesucht = items[i];
				break;
			}
		}
		return gesucht;
	}
	
	String bestellen(Kunde kunde, String[] artikel) {
		
		String rechnung = "";
		if (kunde instanceof GuterKunde) {
			rechnung += "Rechnung fuer unseren guten Kunden " + kunde.toString() + 
					", Preisnachlass " + ((GuterKunde) kunde).getNachlass() * 100  + "%: \n";
		} else {
			rechnung += "Rechnung fuer " + kunde.toString() + ":\n";
		}
		
		double gesPreis = 0;
		
		for (int i=0;i<artikel.length;i++) {
			Artikel curr = sucheArtikel(artikel[i]);
			double artikelpreis = 0;
			if (curr == null) {
				rechnung += artikel[i] + " : nicht gefunden \n";
				continue;
			}
			
			if (curr.getAnzahl() == 0) {
				rechnung += artikel[i] + " : nicht mehr vorhanden \n";
				continue;
			}
			
			if (kunde instanceof GuterKunde) {
				artikelpreis = curr.getPreis() - (curr.getPreis() * ((GuterKunde) kunde).getNachlass()); 
			} else {
				artikelpreis = curr.getPreis();
			}
			gesPreis += artikelpreis;
			rechnung += curr.getName() + " : " + artikelpreis + "\n";
			curr.setAnzahl(curr.getAnzahl()-1);
		}
		
		rechnung += "Gesamtpreis : " + gesPreis + "\n";
		return rechnung;
		
	}
}



/*
String rechnung = "";

this.kunde = kunde;	
this.artikel = artikel;
double betrag = 0;

rechnung += "Rechnung fuer " + kunde.vorname + " " + kunde.nachname + "\n";

for (int i=0;i<artikel.length;i++) {
	for (int j=0;j<this.menge;j++) {
		if ((artikel[i] == items[j].getName()) & (items[j].getAnzahl() > 0)) {
			double preis = items[j].getPreis();
				if (kunde instanceof GuterKunde) {
					kunde = (GuterKunde) kunde;
					preis = preis - (preis * ((GuterKunde) kunde).getNachlass());
				}
			items[j].setAnzahl(items[j].getAnzahl()-1);
			betrag += preis;
			rechnung += artikel[i] + " : " + preis + "\n";
			continue;
		}
		if ((artikel[i] == items[j].getName()) & (items[j].getAnzahl() == 0)) {
			rechnung += artikel[i] + " : " + "Artikel nicht vorhanden \n";
			continue;
		}
		if ((artikel[i] != items[j].getName()) && (items[j].getName() != null)) {
			rechnung += artikel[j] + " : " + "Artikel nicht gefunden"; 
			break;
		}
	}
}
rechnung += "Gesamtpreis : " + betrag + "\n";
return rechnung;*/