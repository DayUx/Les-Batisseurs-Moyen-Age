package model;

public class Batiment extends Carte {

	private boolean construct;
	private int ecus;
	private int pointV;

	/**
	 * Constructeur de Batiment
	 * 
	 * @param nom    le nom du batiment
	 * @param bois   le nombre de bois
	 * @param pierre le nombre de pierre
	 * @param tuile  le nombre de tuile
	 * @param savoir le nombre de savoir
	 * @param pointV le nombre de points de victoire
	 * @param ecus   le nombre d'ecus
	 */
	public Batiment(String nom, int bois, int pierre, int tuile, int savoir, int pointV, int ecus) {
		super(nom, bois, pierre, tuile, savoir);
	}

	/**
	 * Permet de recuperer le nombre de point de victoire
	 * 
	 * @return return le nombre de points de victoire
	 */
	public int getPointVictoire() {
		return pointV;
	}

	/**
	 * Permet de recuperer le nombre d'ecus'
	 * 
	 * @return return le nombre de points d'ecus'
	 */
	public int getEcus() {
		return ecus;
	}

	public void print() {
		System.out.println("Batiment(nom : " + this.getNom() + ", bois : " + this.getBois() + ", pierre : "
				+ this.getPierre() + ", tuile : " + this.getTuile() + ", savoir : " + this.getSavoir() + ", ecus : "
				+ this.getEcus());
	}

}