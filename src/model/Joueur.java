package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Joueur implements Serializable {

	private int ecus;
	private int freeMove;
	private ArrayList<Batiment> batiments;
	private ArrayList<Ouvrier> ouvriers;
	private ArrayList<Ouvrier> working;
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
			this.ouvriers = new ArrayList<Ouvrier>();
			this.batiments = new ArrayList<Batiment>();
			this.chantiers = new ArrayList<Batiment>();
			this.working = new ArrayList<Ouvrier>();

			this.freeMove = 3;
		} else {
			System.out.println("Joueur : parameter is null");
		}
	}

	/**
	 * Permet de recuperer l'objet board
	 * 
	 * @return return l'objet board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * permet de set l'objet board
	 * 
	 * @param board un objet board
	 */
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
		return this.ecus;
	}

	/**
	 * Permet de recuperer la liste des ouvriers qui travaillent sur un chantiers
	 * 
	 * @return return la liste des ouvriers qui travaillent sur un chantiers
	 */
	public ArrayList<Ouvrier> getWorking() {
		return this.working;
	}

	/**
	 * Permet de set le nombre d'ecus
	 * 
	 * @param ecus le nombre d'ecus a set
	 */
	public void setEcus(int ecus) {
		if (ecus >= 0) {
			this.ecus = ecus;
		} else {
			System.out.println("setEcus : amount of ecus must be positive");
		}

	}

	/**
	 * Permet de recuperer les ouvriers du joueur
	 * 
	 * @return les ouvriers du joueur
	 */
	public ArrayList<Ouvrier> getOuvriers() {
		return this.ouvriers;
	}

	/**
	 * Permet de recuperer les chantiers du joueur
	 * 
	 * @return les chantiers du joueur
	 */
	public ArrayList<Batiment> getChantiers() {
		return this.chantiers;
	}

	public ArrayList<Batiment> getBatiments() {
		return this.batiments;
	}

	/**
	 * Permet d'ajouter un ouvrier
	 * 
	 * @param ouvrier l'ouvrier a ajouter
	 */
	public void addOuvrier(Ouvrier ouvrier) {
		this.ouvriers.add(ouvrier);
	}

	/**
	 * Permet de recuperer un batiment
	 * 
	 * @param batiment le batiment que vous voulez recuperer
	 */
	public void addBatiment(Batiment batiment) {
		this.batiments.add(batiment);
	}

	/**
	 * Permet de rajouter un chantier
	 * 
	 * @param batiment le batiment que vous voulez construire
	 */
	public void addChantier(Batiment batiment) {
		this.chantiers.add(batiment);
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
		this.freeMove = 3;
	}

	/**
	 * Permet d'utiliser une action gratuite
	 */
	public void useFreeMove() {
		this.freeMove = this.freeMove - 1;
	}

	public void setPointsV(int i) {
		this.points = i;
	}

	/**
	 * Pemet de recuperer le nombre d'actions gratuites
	 */
	public int getFreeMove() {
		return this.freeMove;
	}

	/**
	 * Permet de print la liste des chantiers lances par le joueur
	 */
	public void printChantiers() {
		int i = 0;
		for (Batiment batiment : this.chantiers) {
			System.out.print(i + ". ");
			batiment.print();
			i++;

			for (Ouvrier ouv : working) {
				if (ouv.getTravaillePour() == batiment) {
					System.out.print("		");
					ouv.print();
				}
			}
			System.out.println();
		}
	}

	/**
	 * Permet d'assigner un ouvrier a un chantier
	 * 
	 * @param ouvrier
	 */
	public void assignWorker(Ouvrier ouvrier, Batiment chantier) {

	}

	/**
	 * permet de recuper le nombre de points de victoire du joueur
	 * 
	 * @return le nombre de points de victoire du joueur
	 */
	public int getPointsV() {
		return this.points;

	}

	public void play() {
	}

	/**
	 * permet de print les ouvriers detenus par le joueur
	 */
	public void printWorkers() {
		int i = 0;
		for (Carte ouvrier : this.ouvriers) {
			System.out.print(i + ". ");
			ouvrier.print();
			i++;
		}
	}

	/**
	 * permet de print les batiments detenus par le joueur
	 */
	public void printBuildings() {
		int i = 0;
		for (Batiment bat : this.batiments) {
			System.out.print(i + ". ");
			bat.print();
			i++;
		}
	}

	/**
	 * permet de print les infos du joueur
	 */
	public void print() {
		System.out.println("########################################################");
		System.out.println("# tours gratuits restants : " + this.freeMove);
		System.out.println("# ecus : " + this.ecus);
		System.out.println("# points de victoire : " + this.points);
		System.out.println("########################################################");
	}

	/**
	 * permet d'assigner un travailleur a un chantier
	 * 
	 * @param wrkr
	 */
	public void work(Ouvrier wrkr) {
		if (wrkr.getTravaillePour() != null) {
			Batiment bat = wrkr.getTravaillePour();
			bat.setBois(bat.getBois() - wrkr.getBois());
			bat.setPierre(bat.getPierre() - wrkr.getPierre());
			bat.setSavoir(bat.getSavoir() - wrkr.getSavoir());
			bat.setTuile(bat.getTuile() - wrkr.getTuile());
		}
	}

	/**
	 * permet de verifier si un chantier est termine et dans ce cas, de reassigner
	 * les ouvrier a leurs bonne liste
	 */
	public void checkWork() {
		ArrayList<Batiment> bat = new ArrayList<Batiment>();
		for (Batiment chantier : chantiers) {
			if (chantier.getBois() <= 0 && chantier.getPierre() <= 0 && chantier.getSavoir() <= 0
					&& chantier.getTuile() <= 0) {
				ArrayList<Ouvrier> ouv = new ArrayList<Ouvrier>();
				for (Ouvrier ouvrier : working) {
					if (ouvrier.getTravaillePour() == chantier) {
						ouvrier.setTravaillePour(null);
						ouv.add(ouvrier);
					}

				}
				for (Ouvrier ouvrier : ouv) {
					working.remove(ouvrier);
					ouvriers.add(ouvrier);
				}

				this.setPointsV(chantier.getPointVictoire());
				this.setEcus(this.getEcus() + chantier.getEcus());
				bat.add(chantier);
			}

		}
		for (Batiment batiment : bat) {
			chantiers.remove(batiment);
			if (batiment.getClass() == Machine.class) {
				Machine mach = (Machine) batiment;
				this.ouvriers.add(new Ouvrier(mach.getNom(), mach.getAmountBois(), mach.getAmountPierre(),
						mach.getAmountTuile(), mach.getAmountSavoir(), 0));
			}
		}
	}
}