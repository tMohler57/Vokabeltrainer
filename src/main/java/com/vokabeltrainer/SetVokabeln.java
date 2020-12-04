package com.vokabeltrainer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetVokabeln {
	List <Vokabel> wort = new ArrayList <Vokabel>();

	public void textdateiEinlesen(String thema) {
		String file = themaWahl(thema);
		try (FileReader f = new FileReader(file)){
			char[] c = new char[10000000];
			f.read(c);
			String s = new String(c);
			String [] result = s.split(";|\n");		

			for(int i = 0; i < result.length; i+=2) {
				wort.add(new Vokabel(result[i].trim(), result[i + 1].trim()));

			}

			// verschoben nach Trainingsbildschirm
			// Collections.shuffle(wort);

		} catch(IOException e) {
			System.err.println("Fehler beim Einlesen der Datei.");
			System.err.println(e.getMessage());
		}
	}

	public List<Vokabel> getWort() {
		return wort;
	}

	public String themaWahl(String thema) {
		switch (thema) {
		case "Tiere":
			return "src/main/java/com/vokabeltrainer/Animaux.txt";
		case "Beruf":
			return "src/main/java/com/vokabeltrainer/Profession.txt";
		case "Tourismus":
			return "src/main/java/com/vokabeltrainer/Tourisme.txt";
		default:
			throw new IllegalArgumentException("Es wurde kein gültiges Thema gewählt.");
		}
		
	}
}
