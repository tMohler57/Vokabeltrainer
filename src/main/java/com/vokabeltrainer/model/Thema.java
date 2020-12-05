package com.vokabeltrainer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public enum Thema {
	Tiere("Animaux", "Animals"), Berufe("Professions-et-bureau", "Professions-and-office"),
	Tourismus("Tourisme-et-transport", "Tourism-and-transport");

	private final String fr, en;

	private Thema(String fr, String en) {
		this.fr = getFilePath(fr);
		this.en = getFilePath(en);
	}

	private static String getFilePath(String name) {
		return "/com/vokabeltrainer/" + name + ".txt";
	}

	public List<Vokabel> datenEinlesen(String sprache, boolean richtungUmkehren) {
		String datei = sprache.equals("Französisch") ? fr : en;
		int index_vokabel = richtungUmkehren ? 1 : 0;
		int index_uebersetzung = 1 - index_vokabel;
		List<Vokabel> vokabeln = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream(datei), "UTF-8"))) {
			String zeile;
			while ((zeile = in.readLine()) != null) {
				String[] woerter = zeile.split(";");
				vokabeln.add(new Vokabel(woerter[index_vokabel].trim(), woerter[index_uebersetzung].trim()));
			}

		} catch (IOException e) {
			throw new RuntimeException("Datei einlesen fehlgeschlagen.", e);
		}
		return vokabeln;
	}
}
