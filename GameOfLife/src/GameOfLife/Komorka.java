package GameOfLife;

import java.util.List;

public class Komorka {
	private StanKomorki stan;
	private StanKomorki zmianaStanu;
	private List<Komorka> sasiedzi;
	private int liczbaZywychSasiadow;

	public Komorka(StanKomorki status) {
		this.stan = status;
		liczbaZywychSasiadow = 0;
		zmianaStanu = StanKomorki.ZYWA;
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
		zmianaStanu = StanKomorki.ZYWA;
		if (liczbaZywychSasiadow < 2 || liczbaZywychSasiadow > 3) {
			zmianaStanu = StanKomorki.MARTWA;
		} else if (stan == StanKomorki.MARTWA && liczbaZywychSasiadow == 3) {
			zmianaStanu = StanKomorki.ZYWA;
		} else if (stan == StanKomorki.MARTWA) {
			zmianaStanu = StanKomorki.MARTWA;
		}
	}

	public void zmienStanDoNastepnejGeneracji() {
		if (zmianaStanu == StanKomorki.MARTWA) {
			stan = StanKomorki.MARTWA;
		}
		else {
			stan = StanKomorki.ZYWA;
		}
	}

	public StanKomorki dajStan() {
		return stan;
	}

}
