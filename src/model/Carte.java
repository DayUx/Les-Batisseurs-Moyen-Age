package model;

public class Carte {
	private String nom;
	private int pierre;
	private int bois;
	private int tuile;
	private int savoir;
	private boolean isMachine;

	/**
	 * Constructeur de Carte
	 * 
	 * @param nom    le nom du batiment
	 * @param bois   le nombre de bois
	 * @param pierre le nombre de pierre
	 * @param tuile  le nombre de tuile
	 * @param savoir le nombre de savoir
	 */
	public Carte(String nom, int bois, int pierre, int tuile, int savoir) {
		if (nom != null) {
			this.nom = nom;
			this.bois = bois;
			this.pierre = pierre;
			this.tuile = tuile;
			this.savoir = savoir;
		} else {
			System.out.println("Carte : parameter is null");
		}
	}

	/**
	 * Permet de recuperer le nom de la carte
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Permet de recuperer le nombre de pierre
	 */
	public int getPierre() {
		return pierre;

	}

	/**
	 * Permet de recuperer le nombre de pierre
	 */
	public int getBois() {
		return bois;
	}

	/**
	 * Permet de recuperer le nombre de savoir
	 * 
	 * @return
	 */
	public int getSavoir() {
		return savoir;
	}

	/**
	 * Permet de recuperer le nombre de tuile
	 * 
	 * @return
	 */
	public int getTuile() {
		return tuile;
	}

	public void print() {
	}

}