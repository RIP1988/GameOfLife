package GameOfLife;

import java.util.List;

public class Komorka {
	private StanKomorki stan;
	private PrzyszlyStanKomorki zmianaStanu;
	private List<Komorka> sasiedzi;
	private int liczbaZywychSasiadow;

	public Komorka(StanKomorki status) {
		this.stan = status;
		liczbaZywychSasiadow = 0;
		zmianaStanu = PrzyszlyStanKomorki.Zycie;
	}

	public void ustawSasiadow(List<Komorka> sasiedzi) {
		this.sasiedzi = sasiedzi;
	}

	public void policzZywychSasiadow() {
		liczbaZywychSasiadow = 0;
		for (Komorka sasiad : sasiedzi) {
			if (sasiad.dajStan() == StanKomorki.ZYWA) {
				liczbaZywychSasiadow++;
			}
		}
	}

	public void ustalCzyZywaWNastepnejGeneracji() {
		zmianaStanu = PrzyszlyStanKomorki.Zycie;
		if (liczbaZywychSasiadow < 2 || liczbaZywychSasiadow > 3) {
			zmianaStanu = PrzyszlyStanKomorki.NaSmierc;
		} else if (stan == StanKomorki.MARTWA && liczbaZywychSasiadow == 3) {
			zmianaStanu = PrzyszlyStanKomorki.Zycie;
		} else if (stan == StanKomorki.MARTWA) {
			zmianaStanu = PrzyszlyStanKomorki.NaSmierc;
		} 
	}

	public void zmienStanDoNastepnejGeneracji() {
		if (zmianaStanu == PrzyszlyStanKomorki.NaSmierc)
			stan = StanKomorki.MARTWA;
		else
			stan = StanKomorki.ZYWA;
	}

	public StanKomorki dajStan() {
		return stan;
	}

}
