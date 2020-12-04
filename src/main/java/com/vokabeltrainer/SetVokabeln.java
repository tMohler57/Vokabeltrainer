package com.vokabeltrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SetVokabeln {
	
	private List <Vokabel> wort = new ArrayList <Vokabel>();
	private String sprache;

	public void textdateiEinlesen(String thema, String sprache) {
		this.sprache = sprache;
		datenEinlesen(themaWahl(thema, sprache));
	}

	public List<Vokabel> getWort() {
		return wort;
	}
	
	public String getSprache() {
		return sprache;
	}

	public String themaWahl(String thema, String sprache) {
		
		return VokabelDatei.valueOf(thema).getFile(sprache);
		
	}
	
	private void datenEinlesen(String datei) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(datei)))) {
			String zeile;
			while ((zeile = in.readLine())!=null) {
				String[] wörter = zeile.split(";");
				wort.add(new Vokabel(wörter[0].trim(), wörter[1].trim()));
			}

		} catch (IOException e) {
			throw new RuntimeException("Datei einlesen fehlgeschlagen.", e);
		}
	}
}
