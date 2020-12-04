package com.vokabeltrainer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetVokabeln {
	
	private List <Vokabel> wort = new ArrayList <Vokabel>();
	private String file;
	private String sprache;
	private String richtung;

	public void textdateiEinlesen(String thema, String sprache, String richtung) {
		file = "./" + themaWahl(thema, sprache);
		this.sprache = sprache;
		this.richtung = richtung;

		try (FileReader f = new FileReader(file)){
			char[] c = new char[10000000];
			f.read(c);
			String s = new String(c);
			String [] result = s.split(";|\n");		

			for(int i = 0; i < result.length; i+=2) {
				if (richtung == "Deutsch → Fremdsprache") {
					wort.add(new Vokabel(result[i].trim(), result[i + 1].trim()));
				}
				else if (richtung == "Fremdsprache → Deutsch") {
					wort.add(new Vokabel(result[i + 1].trim(), result[i].trim()));
				}
			}			
		} 
		catch(IOException e) {
			System.err.println("Fehler beim Einlesen der Datei.");
			System.err.println(e.getMessage());
		}
	}

	public List<Vokabel> getWort() {
		return wort;
	}
	
	public String getFile() {
		return file;
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
}
