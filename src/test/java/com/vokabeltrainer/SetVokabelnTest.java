package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SetVokabelnTest {
	
	@Test
	public void testDateiEinlesen() {
		SetVokabeln wörtli = new SetVokabeln();
		wörtli.textdateiEinlesen("Tiere", "Englisch");
		assertEquals("Englisch", wörtli.getSprache());
		Vokabel ersteVokabel = wörtli.getWort().get(0);
		assertEquals("Fisch", ersteVokabel.getVokabel());
		assertEquals("fish", ersteVokabel.getUebersetzung());
	}
}
