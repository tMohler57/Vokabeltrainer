package com.vokabeltrainer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VokabelModel {
	
	// Die Sprachen Englisch und Französisch stehen dem Benutzer zur Verfügung.
	private final List<String> verfuegbareSprachen = Arrays.asList("Englisch", "Französisch");

	private int countKorrekt = 0;
	private int countGesamt = 0;
	private final List<Vokabel> aktuelleVokabeln = new ArrayList<>(), falscheVokabeln = new ArrayList<>();
	private Boolean richtungUmkehren = false;
	private Thema thema = null;
	private String sprache = null;
	private int index = 0;

	public void ladeDatei() {
		aktuelleVokabeln.clear();
		aktuelleVokabeln.addAll(thema.datenEinlesen(sprache, richtungUmkehren));
		falscheVokabeln.clear();
	}
	
	public List<String> getVerfuegbareSprachen() {
		return verfuegbareSprachen;
	}

	public Boolean isRichtungUmkehren() {
		return richtungUmkehren;
	}
	
	// Errechnen der Erfolgsquote
	public double erfolgsquote() {
		return ( (double)countKorrekt / (double)countGesamt ) * 100;	
	}

	public void setRichtungUmkehren(Boolean richtungUmkehren) {
		this.richtungUmkehren = richtungUmkehren;
	}

	public Thema getThema() {
		return thema;
	}

	public void setThema(Thema thema) {
		this.thema = thema;

	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCountKorrekt() {
		return countKorrekt;
	}

	public void setCountKorrekt(int countKorrekt) {
		this.countKorrekt = countKorrekt;
	}

	public int getCountGesamt() {
		return countGesamt;
	}

	public void setCountGesamt(int countGesamt) {
		this.countGesamt = countGesamt;
	}

	public List<Vokabel> getAktuelleVokabeln() {
		return aktuelleVokabeln;
	}

	public List<Vokabel> getFalscheVokabeln() {
		return falscheVokabeln;
	}
}
