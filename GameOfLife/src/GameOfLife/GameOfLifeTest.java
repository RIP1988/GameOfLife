package GameOfLife;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void testCzyPierwszaKomorkaMartwaWWynikuSamotnosci() {
		ArrayList<Komorka> komorki = new ArrayList<Komorka>();
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		Srodowisko srodowisko = new Srodowisko(3, 3, komorki);
		srodowisko.nastepnaGeneracja();
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(0));
	}

	@Test
	public void testCzyPiataKomorkaMartwaWWynikuPrzeludnienia() {
		ArrayList<Komorka> komorki = new ArrayList<Komorka>();
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		Srodowisko srodowisko = new Srodowisko(3, 3, komorki);
		srodowisko.nastepnaGeneracja();
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(4));
	}

	@Test
	public void testCzyCzwartaKomorkaOzyjeNaSkutekPosiadaniaCzterechSasiadow() {
		ArrayList<Komorka> komorki = new ArrayList<Komorka>();
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		Srodowisko srodowisko = new Srodowisko(3, 3, komorki);
		srodowisko.nastepnaGeneracja();
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(3));
	}

	@Test
	public void testCzyTrzeciaKomorkaZyjeDalejDziekiPosiadaniuDwochSasiadow() {
		ArrayList<Komorka> komorki = new ArrayList<Komorka>();
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		Srodowisko srodowisko = new Srodowisko(3, 3, komorki);
		srodowisko.nastepnaGeneracja();
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(2));
	}

	@Test
	public void testCalegoSrodowiska() {
		ArrayList<Komorka> komorki = new ArrayList<Komorka>();
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Martwa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		komorki.add(new Komorka(StanKomorki.Zywa));
		Srodowisko srodowisko = new Srodowisko(3, 3, komorki);
		srodowisko.nastepnaGeneracja();
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(0));
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(1));
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(2));
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(3));
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(4));
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(5));
		assertEquals(StanKomorki.Martwa, srodowisko.dajStanKomorki(6));
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(7));
		assertEquals(StanKomorki.Zywa, srodowisko.dajStanKomorki(8));
	}
}
