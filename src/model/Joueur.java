package model;

import java.util.ArrayList;

public class Joueur {

	private int ecus;
	private int freeMove;
	private ArrayList<Batiment> batiments;
	private ArrayList<Carte> ouvriers;
	private ArrayList<Batiment> chantiers;
	private int points;
	private String nom;
	private Board board;

	/**
	 * Constructeur de joueur
	 * 
	 * @param nom nom du joueur
	 */
	public Joueur(String nom) {
		if (nom != null) {
			this.nom = nom;
			this.ouvriers = new ArrayList<Carte>();
			this.batiments = new ArrayList<Batiment>();
			this.chantiers = new ArrayList<Batiment>();
		} else {
			System.out.println("Joueur : parameter is null");
		}
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		if (board != null) {
			this.board = board;
		} else {
			System.out.println("setBoard : parameter is null");
		}
	}

	/**
	 * Permet de recuperer le nombre d'ecus du joueur
	 * 
	 * @return le nombre d'ecus
	 */
	public int getEcus() {
		return 0;
	}

	/**
	 * Permet de set le nombre d'ecus
	 * 
	 * @param ecus
	 */
	public void setEcus(int ecus) {

	}

	/**
	 * Permet de recuperer les ouvriers du joueur
	 * 
	 * @return les ouvriers du joueur
	 */
	public ArrayList<Ouvrier> getOuvriers() {
		return new ArrayList<Ouvrier>();
	}

	/**
	 * Permet de recuperer les chantiers du joueur
	 * 
	 * @return les chantiers du joueur
	 */
	public Batiment getChantiers() {
		return new Batiment("", 0, 0, 0, 0, 0, 0);
	}

	/**
	 * Permet d'ajouter un ouvrier
	 * 
	 * @param ouvrier l'ouvrier a ajouter
	 */
	public void addOuvrier(Ouvrier ouvrier) {
		this.ouvriers.add(ouvrier);
	}

	public void addBatiment(Batiment batiment) {
		this.batiments.add(batiment);
	}

	/**
	 * Permet de commencer un chantier
	 * 
	 * @param batiment le batiment a construire
	 */
	public void startChantier(Batiment batiment) {

	}

	/**
	 * Permet de recuperer le nom du joueur
	 * 
	 * @return return le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet de reset le nombre d'actions gratuites
	 */
	public void resetFreeMove() {

	}

	/**
	 * Permet d'utiliser une action gratuite
	 */
	public void useFreeMove() {

	}

	public void setPointsV(int i) {
		this.points = i;
	}

	/**
	 * Pemet de recuperer le nombre d'actions gratuites
	 */
	public int getFreeMove() {
		return 0;
	}

	public void printChantiers() {
		int i = 0;
		for (Batiment batiment : this.chantiers) {
			System.out.print(i);
			batiment.print();
			i++;
		}
	}

	/**
	 * Permet d'assigner un ouvrier a un chantier
	 * 
	 * @param ouvrier
	 */
	public void assignWorker(Ouvrier ouvrier, Batiment chantier) {

	}

	public int getPointsV() {
		return this.points;

	}

	public void play() {
	}

	public void printWorkers() {
		for (Carte ouvrier : this.ouvriers) {
			ouvrier.print();
		}
	}

	public void printBuildings() {
		for (Batiment bat : this.batiments) {
			bat.print();
		}
	}

	public void print() {
		System.out.println("########################################################");
		System.out.println("# tours gratuits restants : " + this.freeMove);
		System.out.println("# ecus : " + this.ecus);
		System.out.println("# points de victoire : " + this.points);
		System.out.println("########################################################");
	}

	public void drawCard(int index) {
		if (freeMove > 0) {

		}
	}
}