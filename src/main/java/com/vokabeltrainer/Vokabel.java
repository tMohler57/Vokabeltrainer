package com.vokabeltrainer;

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
	public void setVokabel(String vokabel) {
		this.vokabel = vokabel;
	}
	
	public String getUebersetzung() {
		return uebersetzung;
	}
	public void setUebersetzung(String uebersetzung) {
		this.uebersetzung = uebersetzung;
	}
}
