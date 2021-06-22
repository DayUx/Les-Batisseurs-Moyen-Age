package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import utilitaire.Input;

public class Batisseurs {
	private Mode mode;
	private ArrayList<Joueur> players = new ArrayList<Joueur>();
	private Game game;

	/**
	 * Constructeur de Batisseurs
	 */
	public Batisseurs() {
		createPlayers();
		newGame();
	}

	/**
	 * Constructeur de batisseur
	 * 
	 * @param file nom du fichier de sauvegarde se trouvant dans data
	 */
	public Batisseurs(String file) {

		try {
			FileInputStream streamIn = new FileInputStream("../data/" + file);
			ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
			Game readCase = (Game) objectinputstream.readObject();
			this.game = readCase;
			this.game.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet de charger une partie grace a un fichier
	 * 
	 * @param file le chemin du fichier
	 */
	public void loadGame(String file) {

	}

	/**
	 * permet de creer une nouvelle partie
	 */
	public void newGame() {
		this.game = new Game(this.players);
		this.game.start();
	}

	/**
	 * permet de creer les joueurs
	 */
	public void createPlayers() {

		System.out.println("##################################################################");
		System.out.println("#            - Selectionnez le type de partie -                  #");
		System.out.println("#  Entrez le type de partie (exemple : HHA, 2 joueurs et 1 bot)  #");
		System.out.println("############################################s#####################");
		String in = "";
		while (in.length() > 4 || in.length() < 2) {
			in = Input.getString();
			in = in.replace("h", "H");
			in = in.replace("a", "A");
			in = in.replace(" ", "");
		}

		int nbH = in.length() - in.replace("H", "").length();
		int nbA = in.length() - in.replace("A", "").length();
		String res = "";
		for (int i = 0; i < nbH; i++) {
			res = res + "H";
		}
		for (int i = 0; i < nbA; i++) {
			res = res + "A";
		}
		this.mode = this.mode.valueOf(res);

		int nbBot = mode.getNbBot();
		int nbHum = mode.getNbHuman();

		for (int i = 0; i < nbHum; i++) {
			System.out.println("Nom du joueurs " + (i + 1));
			String nom = Input.getString();
			players.add(new Humain(nom));
		}
		for (int i = 0; i < nbBot; i++) {
			System.out.println("Nom du bot " + (i + 1));
			String nom = Input.getString();
			players.add(new IA(nom));
		}
	}
}