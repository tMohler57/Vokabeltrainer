package com.vokabeltrainer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Vokabeln {
	
	public String vokabeln() {

		try (FileReader f = new FileReader("src/main/java/com/vokabeltrainer/tiere.txt")){
			char[] c = new char[10000000];
			f.read(c);
			String s = new String(c);
			String [] result = s.split(";|\n");
			Vector<String> vokabel = new Vector<String>();

			for(int i = 0; i < result.length; i= i + 2) {
				vokabel.add(result[i]);	
			}
			
			int zufallszahl = (int)((Math.random()) * vokabel.size());
			
			return vokabel.elementAt(zufallszahl);

		} catch(IOException e) {
			System.err.println("Fehler beim Einlesen der Datei.");
			System.err.println(e.getMessage());
			
			return null;
		}
		
	} 
}
