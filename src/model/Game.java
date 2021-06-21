package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
	private ArrayList<Joueur> players;
	private Board board;
	private Joueur currentPlayer;
	private int row = 1;

	/**
	 * Constructeur de Game
	 * 
	 * @param joueurs la liste des joueurs
	 */
	public Game(ArrayList<Joueur> joueurs) {
		if (joueurs != null) {

			this.players = joueurs;
			this.currentPlayer = this.players.get(0);
			this.board = new Board(this.players, this.currentPlayer);
		} else {
			System.out.println("Game : param is null");
		}

	}

	/**
	 * Methode qui contient la boucle du jeu
	 */
	public void start() {
		this.board.setCurrentPlayer(this.currentPlayer);
		while (!this.board.gameFinish()) {
			this.currentPlayer.print();
			System.out.println("#############################################");
			System.out.println("# Joueur " + this.currentPlayer.getNom() + " a vous de jouer ");
			System.out.println("# tour numero " + this.row);
			System.out.println("#############################################");
			this.currentPlayer.play();
			this.currentPlayer.setPointsV(18);
		}
	}

	/**
	 * Permet de changer le joueur qui joue actuellement
	 */
	public void changeCurrentPlayer() {
	}

	/**
	 * Permet de recuperer le numero du tour actuel
	 * 
	 * @return
	 */
	public int getRow() {
		return 0;
	}

	/**
	 * renvoie le message de fin de partie
	 * 
	 * @return return le message de fin de partie
	 */
	public String endGame() {
		return "";
	}

	/**
	 * renvoie le message de debut de partie
	 * 
	 * @return return le message de debut de partie
	 */
	public String startGame() {
		return "";
	}

	/**
	 * Permet de sauvegarder la partie
	 * 
	 * @param folderPath l'endroit ou vous voulez sauvegarder le fichier
	 */
	public void save(String folderPath) {
	}

	/**
	 * Permet de recuperer l'objet board
	 * 
	 * @return return l'objet board
	 */
	public Board getBoard() {
		return this.board;
	}
}