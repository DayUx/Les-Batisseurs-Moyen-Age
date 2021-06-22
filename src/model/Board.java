package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import utilitaire.RWFile;

public class Board implements Serializable {

	private Joueur currentPlayer;
	private Game game;
	private ArrayList<Joueur> players;
	private ArrayList<Ouvrier> apprentis;
	private ArrayList<Ouvrier> ouvriers;
	private ArrayList<Batiment> batiments;
	private ArrayList<Batiment> piocheBat;
	private ArrayList<Ouvrier> piocheOuv;

	/**
	 * Permet de recuperer les cartes ouvriers presentes sur le plateau
	 * 
	 * @return return les cartes ouvriers presentes sur le plateau
	 */
	public ArrayList<Ouvrier> getCardsOuv() {
		return this.ouvriers;
	}

	/**
	 * Constructeur de board
	 */
	public Board(ArrayList<Joueur> players, Joueur currentPlayer, Game game) {
		if (players != null && currentPlayer != null) {
			this.players = players;
			this.currentPlayer = currentPlayer;
			this.piocheOuv = new ArrayList<Ouvrier>();
			this.piocheBat = new ArrayList<Batiment>();
			this.apprentis = new ArrayList<Ouvrier>();
			this.batiments = new ArrayList<Batiment>();
			this.ouvriers = new ArrayList<Ouvrier>();
			this.game = game;
			initializePlayers();
			initializeOuvriers();
			initializeBatiments();
			fillDecks();
		} else {
			System.out.println("Board : parameter is null");
		}
	}

	/**
	 * Permet de recuperer l'objet game
	 * 
	 * @return return l'objet game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Permet d'initialiser les ecus et autre attributs des joueurs
	 */
	public void initializePlayers() {
		for (Joueur ply : this.players) {
			ply.setBoard(this);
			ply.setEcus(10);
		}
	}

	/**
	 * Permet de remplir la liste des cartes presentent sur le plateau de jeu
	 */
	public void fillDecks() {
		while (this.ouvriers.size() < 5 && this.piocheOuv.size() != 0) {
			this.ouvriers.add(this.piocheOuv.remove(this.piocheOuv.size() - 1));
		}
		while (this.batiments.size() < 5 && this.piocheBat.size() != 0) {
			this.batiments.add(this.piocheBat.remove(this.piocheBat.size() - 1));
		}
	}

	/**
	 * Permet de print les cartes du plateau de jeu
	 */
	public void printCards() {
		System.out.println("###################################################");
		System.out.println("Batiments : ");
		System.out.println();
		for (Batiment bat : this.batiments) {
			bat.print();

		}

		System.out.println();
		System.out.println("Ouvriers");
		System.out.println();
		for (Ouvrier ouv : this.ouvriers) {
			ouv.print();
		}
		System.out.println("###################################################");

	}

	/**
	 * Permet de print les cartes ouvrier presents sur le plateau de jeu
	 */
	public void printOuv() {
		int i = 0;
		for (Ouvrier ouvrier : ouvriers) {
			System.out.print(i + ". ");
			ouvrier.print();
			i++;
		}
	}

	/**
	 * Permet de print les cartes batiments presents sur le plateau de jeu
	 */
	public void printBat() {
		int i = 0;
		for (Batiment batiment : batiments) {
			System.out.print(i + ". ");
			batiment.print();
			i++;
		}
	}

	/**
	 * Permet de d'initialiser les carte ouvrier a l'aide d'un fichier
	 */
	public void initializeOuvriers() {
		ArrayList<String> file = RWFile.readFile("../data/ouvrier.csv");
		for (String string : file) {

			int pierre = 0;
			int bois = 0;
			int savoir = 0;
			int tuile = 0;
			int salaire = 0;
			String tmp = "";

			String nom = string.substring(0, string.indexOf(";"));
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				salaire = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pierre = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				bois = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				savoir = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.length());
			if (!tmp.equals("")) {
				tuile = Integer.parseInt(tmp);
			}

			if (nom.equals("Apprenti")) {
				this.apprentis.add(new Ouvrier(nom, bois, pierre, tuile, savoir, salaire));
			} else {
				this.piocheOuv.add(new Ouvrier(nom, bois, pierre, tuile, savoir, salaire));
			}

		}

		Collections.shuffle(this.apprentis);
		for (Joueur ply : players) {
			ply.addOuvrier(this.apprentis.remove(this.apprentis.size() - 1));
		}

		for (Ouvrier apprenti : this.apprentis) {
			this.piocheOuv.add(apprenti);
		}
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(this.piocheOuv);
		}
	}

	/**
	 * Permet de d'initialiser les carte machines et batiments a l'aide d'un fichier
	 */
	public void initializeBatiments() {
		ArrayList<String> file = RWFile.readFile("../data/machines.csv");
		for (String string : file) {
			int pierre = 0;
			int bois = 0;
			int savoir = 0;
			int tuile = 0;
			int pointV = 0;
			int pierreReward = 0;
			int boisReward = 0;
			int savoirReward = 0;
			int tuileReward = 0;
			String tmp = "";

			String nom = string.substring(0, string.indexOf(";"));
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pierreReward = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				boisReward = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				savoirReward = Integer.parseInt(tmp);
			}

			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				tuileReward = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pointV = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pierre = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				bois = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				savoir = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.length());
			if (!tmp.equals("")) {
				tuile = Integer.parseInt(tmp);
			}

			this.piocheBat.add(new Machine(nom, bois, pierre, tuile, savoir, pointV, pierreReward, boisReward,
					savoirReward, tuileReward));
		}

		file = RWFile.readFile("../data/batiments.csv");
		for (String string : file) {
			int pierre = 0;
			int bois = 0;
			int savoir = 0;
			int tuile = 0;
			int pointV = 0;
			int ecus = 0;
			String tmp = "";

			String nom = string.substring(0, string.indexOf(";"));
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				ecus = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pointV = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				pierre = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				bois = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.indexOf(";"));
			if (!tmp.equals("")) {
				savoir = Integer.parseInt(tmp);
			}
			string = string.substring(string.indexOf(";") + 1);

			tmp = string.substring(0, string.length());
			if (!tmp.equals("")) {
				tuile = Integer.parseInt(tmp);
			}

			this.piocheBat.add(new Batiment(nom, bois, pierre, tuile, savoir, pointV, ecus));
		}
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(this.piocheBat);
		}
	}

	/**
	 * Permet de saisir le joueur qui joue
	 * 
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Joueur currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Permet de recuperer les cartes batiments presentes sur le plateau
	 * 
	 * @return return les cartes batiments presentes sur le plateau
	 */
	public ArrayList<Batiment> getCardsBat() {
		return this.batiments;
	}

	/**
	 * Permet de verifier si la partie a ete gagne par un joueur
	 * 
	 * @return return true si la partie a ete gagne par un joueur
	 */
	public boolean gameFinish() {
		return this.currentPlayer.getPointsV() >= 17;
	}

}