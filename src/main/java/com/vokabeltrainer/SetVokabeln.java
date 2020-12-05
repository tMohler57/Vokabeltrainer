package com.vokabeltrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SetVokabeln {

	private List<Vokabel> wort = new ArrayList<Vokabel>();
	private String sprache;
	private String richtung;

	public void textdateiEinlesen(String thema, String sprache, String richtung) {
		this.sprache = sprache;
		datenEinlesen(themaWahl(thema, sprache), richtung);
	}

	public List<Vokabel> getWort() {
		return wort;
	}

	public String getSprache() {
		return sprache;
	}

	public String getRichtung() {
		return richtung;
	}

	public String themaWahl(String thema, String sprache) {

		return VokabelDatei.valueOf(thema).getFile(sprache);

	}

	private void datenEinlesen(String datei, String richtung) {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream(datei), "UTF-8"))) {
			String zeile;
			if (richtung == "Deutsch → Fremdsprache") {
				while ((zeile = in.readLine()) != null) {
					String[] woerter = zeile.split(";");
					wort.add(new Vokabel(woerter[0].trim(), woerter[1].trim()));
				}
			} else {
				while ((zeile = in.readLine()) != null) {
					String[] woerter = zeile.split(";");
					wort.add(new Vokabel(woerter[1].trim(), woerter[0].trim()));
				}
			}

		} catch (IOException e) {
			throw new RuntimeException("Datei einlesen fehlgeschlagen.", e);
		}
	}
}
