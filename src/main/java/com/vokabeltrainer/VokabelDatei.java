package com.vokabeltrainer;

public enum VokabelDatei {
	Tiere("Animaux", "Animals"),
	Berufe("Professions-et-bureau", "Profession-and-office"),
	Tourismus("Tourisme-et-transport", "Tourism-and-transport");
	private final String fr, en;
	private VokabelDatei(String fr, String en) {
		this.fr = getFilePath(fr);
		this.en = getFilePath(en);
	}
	private static String getFilePath(String name) {
		return "/src/main/resources/com/vokabeltrainer/" + name + ".txt";
	}
	public String getFile(String sprache) {
		switch (sprache) {
		case "Französisch":
			return fr;
		case "Englisch":
			return en;
		default:
			throw new IllegalArgumentException("Sprache '"+sprache+"' nicht vorhanden.");
		}
	}
}
