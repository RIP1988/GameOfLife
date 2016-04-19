package GameOfLife;

import java.util.ArrayList;

public class Komorka {
	private StanKomorki stan;
	private PrzyszlyStanKomorki zmianaStanu;
	private ArrayList<Komorka> sasiedzi;
	private int liczbaZywychSasiadow;

	public Komorka(StanKomorki status) {
		this.stan = status;
		liczbaZywychSasiadow = 0;
		zmianaStanu = PrzyszlyStanKomorki.Zycie;
	}

	public void ustawSasiadow(ArrayList<Komorka> sasiedzi) {
		this.sasiedzi = sasiedzi;
	}

	public void policzZywychSasiadow() {
		liczbaZywychSasiadow = 0;
		for (Komorka sasiad : sasiedzi) {
			if (sasiad.dajStan() == StanKomorki.Zywa) {
				liczbaZywychSasiadow++;
			}
		}
	}

	public void ustalCzyZywaWNastepnejGeneracji() {
		zmianaStanu = PrzyszlyStanKomorki.Zycie;
		if (liczbaZywychSasiadow < 2 || liczbaZywychSasiadow > 3) {
			zmianaStanu = PrzyszlyStanKomorki.NaSmierc;
		} else if (stan == StanKomorki.Martwa && liczbaZywychSasiadow == 3) {
			zmianaStanu = PrzyszlyStanKomorki.Zycie;
		} else if (stan == StanKomorki.Martwa) {
			zmianaStanu = PrzyszlyStanKomorki.NaSmierc;
		} 
	}

	public void zmienStanDoNastepnejGeneracji() {
		if (zmianaStanu == PrzyszlyStanKomorki.NaSmierc)
			stan = StanKomorki.Martwa;
		else
			stan = StanKomorki.Zywa;
	}

	public StanKomorki dajStan() {
		return stan;
	}

}
