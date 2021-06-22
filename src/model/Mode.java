package model;

import java.io.Serializable;

public enum Mode implements Serializable {
	HH, HHH, HHHH, AA, AAA, AAAA, HA, HAA, HAAA, HHA, HHAA, HHHA;

	public int getNbBot() {
		return this.toString().length() - this.toString().replaceAll("A", "").length();
	}

	public int getNbHuman() {
		return this.toString().length() - this.toString().replaceAll("H", "").length();
	}
}
