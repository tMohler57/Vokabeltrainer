package com.vokabeltrainer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VokabelModelTest {
	
	@Test
	public void testDateiEinlesen() {
		VokabelModel woertli = new VokabelModel();
		woertli.setSprache("Englisch");
		woertli.setThema(Thema.Tiere);
		woertli.setRichtungUmkehren(false);
		woertli.ladeDatei();
		assertEquals("Englisch", woertli.getSprache());
		Vokabel ersteVokabel = woertli.getAktuelleVokabeln().get(0);
		assertEquals("Fisch", ersteVokabel.getVokabel());
		assertEquals("fish", ersteVokabel.getUebersetzung());
	}
}
