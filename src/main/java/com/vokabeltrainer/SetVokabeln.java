package com.vokabeltrainer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SetVokabeln {
	List <Vokabel> wort = new ArrayList <Vokabel>();
	
	public void textdateiEinlesen() {
		try (FileReader f = new FileReader("src/main/java/com/vokabeltrainer/tiere.txt")){
			char[] c = new char[10000000];
			f.read(c);
			String s = new String(c);
			String [] result = s.split(";|\n");		

			for(int i = 0; i < result.length; i+=2) {
				wort.add(new Vokabel(result[i].trim(), result[i + 1].trim()));
			
			}
			
			Collections.shuffle(wort);

		} catch(IOException e) {
			System.err.println("Fehler beim Einlesen der Datei.");
			System.err.println(e.getMessage());
		}
	}

	public List<Vokabel> getWort() {
		return wort;
	}
}
