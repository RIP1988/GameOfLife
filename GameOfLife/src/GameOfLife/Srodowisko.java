package GameOfLife;

import java.lang.Math;
import java.util.ArrayList;

public class Srodowisko {
	private int szerokoscSrodowiska;
	private int wysokoscSrodowiska;
	private int liczbaKomorekWSrodowisku;
	private ArrayList<Komorka> populacja;

	public Srodowisko(int szerokosc, int wysokosc, ArrayList<Komorka> populacja) {
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
		ArrayList<Integer> indeksyPotencjalnychSasiadow = new ArrayList<Integer>();
		ArrayList<Komorka> sasiedzi = new ArrayList<Komorka>();
		int indeksKomorkiSzukajacejSasiadow = populacja.indexOf(komorka);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - szerokoscSrodowiska + 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska - 1);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska);
		indeksyPotencjalnychSasiadow.add(indeksKomorkiSzukajacejSasiadow + szerokoscSrodowiska + 1);
		for (int i = 0; i < 3; i++) {
			int indeksSprawdzanejKomorki = indeksyPotencjalnychSasiadow.get(i);
			if (indeksSprawdzanejKomorki >= 0 && indeksSprawdzanejKomorki < liczbaKomorekWSrodowisku
					&& czyWSasiednimRzedzie(indeksSprawdzanejKomorki, indeksKomorkiSzukajacejSasiadow)) {
				sasiedzi.add(populacja.get(indeksSprawdzanejKomorki));
			}
		}
		for (int i = 3; i < 5; i++) {
			int indeksSprawdzanejKomorki = indeksyPotencjalnychSasiadow.get(i);
			if (indeksSprawdzanejKomorki >= 0 && indeksSprawdzanejKomorki < liczbaKomorekWSrodowisku
					&& czyWTymSamymRzedzie(indeksSprawdzanejKomorki, indeksKomorkiSzukajacejSasiadow)) {
				sasiedzi.add(populacja.get(indeksSprawdzanejKomorki));
			}
		}
		for (int i = 5; i < 8; i++) {
			int indeksSprawdzanejKomorki = indeksyPotencjalnychSasiadow.get(i);
			if (indeksSprawdzanejKomorki >= 0 && indeksSprawdzanejKomorki < liczbaKomorekWSrodowisku
					&& czyWSasiednimRzedzie(indeksSprawdzanejKomorki, indeksKomorkiSzukajacejSasiadow)) {
				sasiedzi.add(populacja.get(indeksSprawdzanejKomorki));
			}
		}
		komorka.ustawSasiadow(sasiedzi);
	}

	public StanKomorki dajStanKomorki(int indeks) {
		return populacja.get(indeks).dajStan();
	}

	private boolean czyWTymSamymRzedzie(int indeksKomorki1, int indeksKomorki2) {
		if (indeksKomorki1 / szerokoscSrodowiska == indeksKomorki2 / szerokoscSrodowiska)
			return true;
		return false;
	}

	private boolean czyWSasiednimRzedzie(int indeksKomorki1, int indeksKomorki2) {
		if (Math.abs((indeksKomorki1 / szerokoscSrodowiska) - (indeksKomorki2 / szerokoscSrodowiska)) == 1)
			return true;
		return false;
	}
}
