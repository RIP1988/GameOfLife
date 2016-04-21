package GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Srodowisko {
	private int szerokoscSrodowiska;
	private int wysokoscSrodowiska;
	private int liczbaKomorekWSrodowisku;
	private List<Komorka> populacja;

	public Srodowisko(int szerokosc, int wysokosc, List<Komorka> populacja) {
		this.szerokoscSrodowiska = szerokosc;
		this.wysokoscSrodowiska = wysokosc;
		liczbaKomorekWSrodowisku = szerokoscSrodowiska * wysokoscSrodowiska;
		this.populacja = populacja;
		for (Komorka komorka : populacja) {
			ustalSasiadow(komorka);
		}
	}

	public void nastepnaGeneracja() {
		for (Komorka komorka : populacja) {
			komorka.policzZywychSasiadow();
			komorka.ustalCzyZywaWNastepnejGeneracji();
		}
		for (Komorka komorka : populacja) {
			komorka.zmienStanDoNastepnejGeneracji();
		}
	}

	private void ustalSasiadow(Komorka komorka) {
		List<Integer> indeksyPotencjalnychSasiadow = new ArrayList<Integer>();
		List<Komorka> sasiedzi = new ArrayList<Komorka>();
		int indeksKomorkiSzukajacejSasiadow = populacja.indexOf(komorka);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska + 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska + 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + 1);
		for (int i = 0; i < 6; i++) {
			int indeksSprawdzanejKomorki = indeksyPotencjalnychSasiadow.get(i);
			if (indeksSprawdzanejKomorki >= 0 && indeksSprawdzanejKomorki < liczbaKomorekWSrodowisku
					&& czyWSasiednimRzedzie(indeksSprawdzanejKomorki, indeksKomorkiSzukajacejSasiadow)) {
				sasiedzi.add(populacja.get(indeksSprawdzanejKomorki));
			}
		}
		for (int i = 6; i < 8; i++) {
			int indeksSprawdzanejKomorki = indeksyPotencjalnychSasiadow.get(i);
			if (indeksSprawdzanejKomorki >= 0 && indeksSprawdzanejKomorki < liczbaKomorekWSrodowisku
					&& czyWTymSamymRzedzie(indeksSprawdzanejKomorki, indeksKomorkiSzukajacejSasiadow)) {
				sasiedzi.add(populacja.get(indeksSprawdzanejKomorki));
			}
		}
		komorka.ustawSasiadow(sasiedzi);
	}

	public StanKomorki dajStanKomorki(int indeks) {
		return populacja.get(indeks).dajStan();
	}

	private boolean czyWTymSamymRzedzie(int indeksKomorki1, int indeksKomorki2) {
		return (indeksKomorki1 / szerokoscSrodowiska == indeksKomorki2 / szerokoscSrodowiska);
	}

	private boolean czyWSasiednimRzedzie(int indeksKomorki1, int indeksKomorki2) {
		return (Math.abs((indeksKomorki1 / szerokoscSrodowiska) - (indeksKomorki2 / szerokoscSrodowiska)) == 1);
	}
}
