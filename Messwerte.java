
public class Messwerte {
	private int n;
	private int m;
	private static int allWert = 0;
	private static int zaehler = 0;
	private int[] werte;
	
	
	public Messwerte(int n) {
		this.n = n;
		this.m = 0;
		this.werte = new int[0];
	}
	
	public void messwert(int wert) {
		allWert = allWert + wert;
		zaehler++;
		int[] alteWerte = new int[werte.length+1];
		
		for(int i=0;i<werte.length;i++) {
			alteWerte[i] = werte[i];
		}
		
		alteWerte[werte.length] = wert;
		
		werte = alteWerte;
		this.m++;
	}
	
	public double getWert() {
		double wert = 0;
		if(m == 0) {
			return 0.0;
		} else if(m < n) {
			for(int i=0;i<m;i++) {
				wert = wert + werte[i];
			}
			wert = wert / m;
			return wert;
		} else {
			int x = werte.length - n;
			for(int i=x;i<werte.length;i++) {
				wert = wert + werte[i];
			}
			wert = wert / n;
			return wert;
		}
	}
	
	public double getAll() {
		double wert = 0;
		int i=0;
		for(;i<werte.length;i++) {
			wert = wert + werte[i];
		}
		wert = wert / i;
		return wert;
	}
	
	public static double getAlleMesswerte() {
		double wert = 0;
		wert = allWert / zaehler;
		return wert;
	}
	
	public static int getAnzahl() {
		return zaehler;
	}
	
	public static void main(String[] args) {
		Messwerte m1 = new Messwerte(2);
		
		m1.messwert(10);
		m1.messwert(20);
		m1.messwert(40);
		m1.messwert(30);
		m1.messwert(60);
		m1.messwert(50);
		
		System.out.println(m1.getWert());
		System.out.println(m1.getAll());
	//	System.out.println(m1.getAlleMesswerte());
		System.out.println(m1.getAnzahl());
		/*
		Messwerte m2 = new Messwerte(4);
		m2.messwert(10);
		m2.messwert(20);
		m2.messwert(30);
		m2.messwert(40);
		m2.messwert(50);
		m2.messwert(60);
		
		System.out.println(m2.getWert());
		System.out.println(m2.getAll());
		System.out.println(m1.getAlleMesswerte());
		*/
	}
}
