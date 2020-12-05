package com.vokabeltrainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SetVokabelnTest {
	
	@Test
	public void testDateiEinlesen() {
		SetVokabeln woertli = new SetVokabeln();
		woertli.textdateiEinlesen("Tiere", "Englisch", "Deutsch → Fremdsprache");
		assertEquals("Englisch", woertli.getSprache());
		Vokabel ersteVokabel = woertli.getWort().get(0);
		assertEquals("Fisch", ersteVokabel.getVokabel());
		assertEquals("fish", ersteVokabel.getUebersetzung());
	}
}
