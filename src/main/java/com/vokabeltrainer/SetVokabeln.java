package com.vokabeltrainer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetVokabeln {
	
	private List <Vokabel> wort = new ArrayList <Vokabel>();
	private String file;
	private String richtung;

	public void textdateiEinlesen(String thema, String sprache, String richtung) {
		file = themaWahl(thema, sprache);
		this.richtung = richtung;
		
		try (FileReader f = new FileReader(file)){
			char[] c = new char[10000000];
			f.read(c);
			String s = new String(c);
			String [] result = s.split(";|\n");		

			for(int i = 0; i < result.length; i+=2) {
				if (richtung == "Deutsch --> Fremdsprache") {
					wort.add(new Vokabel(result[i].trim(), result[i + 1].trim()));
				}
				else if (richtung == "Fremdsprache --> Deutsch") {
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
	
	public String getRichtung() {
		return richtung;
	}

	public String themaWahl(String thema, String sprache) {
		switch (thema) {
		case "Tiere":
			if(sprache == "Französisch") {
				return "src/main/java/com/vokabeltrainer/Animaux.txt";
			}
			else if(sprache == "Englisch") {
				return "src/main/java/com/vokabeltrainer/Animals.txt";
			}			
		case "Tourismus":
			if(sprache == "Französisch") {
				return "src/main/java/com/vokabeltrainer/Tourisme-et-transport.txt";
			}
			else if(sprache == "Englisch") {
				return "src/main/java/com/vokabeltrainer/Tourism-and-transport.txt";
			}			
		case "Beruf":
			if(sprache == "Französisch") {
				return "src/main/java/com/vokabeltrainer/Professions-et-bureau.txt";
			}
			else if(sprache == "Englisch") {
				return "src/main/java/com/vokabeltrainer/Professions-and-office.txt";
			}			
		default:
			throw new IllegalArgumentException("Es wurde kein gültiges Thema oder keine gültige Sprache gewählt.");
		}		
	}
}
