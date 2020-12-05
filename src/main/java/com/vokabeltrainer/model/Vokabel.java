package com.vokabeltrainer.model;

public class Vokabel {
	
	private String vokabel;
	private String uebersetzung;
	
	public Vokabel(String vokabel, String uebersetzung) {
		this.vokabel = vokabel;
		this.uebersetzung = uebersetzung;
	}
	
	public String getVokabel() {
		return vokabel;
	}
	
	public String getUebersetzung() {
		return uebersetzung;
	}
}
