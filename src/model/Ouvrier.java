package model;

public class Ouvrier extends Carte {
	private Batiment travaillePour;
	private int salaire;

	/**
	 * Constructeur de Ouvrier
	 * 
	 * @param nom    le nom de l'ouvrier
	 * @param bois   le nombre de bois
	 * @param pierre le nombre de pierre
	 * @param tuile  le nombre de tuile
	 * @param savoir le nombre de savoir
	 */
	public Ouvrier(String nom, int bois, int pierre, int tuile, int savoir, int salaire) {
		super(nom, bois, pierre, tuile, savoir);
		this.salaire = salaire;
	}

	/**
	 * Permet de recuperer le salaire de l'ouvrier
	 * 
	 * @return
	 */
	public int getSalaire() {
		return this.salaire;
	}

	/**
	 * Permet de savoir sur quel chantier il travaille
	 * 
	 * @return return le chantier sur lequel il travaille
	 */
	public Batiment getTravaillePour() {
		return this.travaillePour;
	}

	/**
	 * Permet d'assigner l'ouvrier a un chantier
	 */
	public void setTravaillePour(Batiment b) {
		this.travaillePour = b;

	}

	/**
	 * permet de print les infoos d'un ouvrier
	 */
	public void print() {
		System.out.println("Ouvrier( nom : " + this.getNom() + ", bois : " + this.getBois() + ", pierre : "
				+ this.getPierre() + ", tuile : " + this.getTuile() + ", savoir : " + this.getSavoir() + ", salaire : "
				+ this.getSalaire());
	}

}