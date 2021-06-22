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
			this.board = new Board(this.players, this.currentPlayer, this);
		} else {
			System.out.println("Game : parameter is null");
		}

	}

	/**
	 * Methode qui contient la boucle du jeu
	 */
	public void start() {
		this.board.setCurrentPlayer(this.currentPlayer);
		while (!this.board.gameFinish()) {
			changeCurrentPlayer();
			this.board.setCurrentPlayer(this.currentPlayer);
			System.out.println("#############################################");
			System.out.println("# Joueur " + this.currentPlayer.getNom() + " a vous de jouer ");
			System.out.println("# tour numero " + this.row);
			System.out.println("#############################################");

			this.currentPlayer.play();
			rowPlus();

		}
	}

	/**
	 * Permet de changer le joueur qui joue actuellement
	 */
	public void changeCurrentPlayer() {
		int size = players.size();
		int indx = players.indexOf(this.currentPlayer);
		if (indx == (size - 1)) {
			indx = 0;
		} else {
			indx = indx + 1;
		}
		this.currentPlayer = players.get(indx);
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
	 * Incremente l'attribut row
	 */
	public void rowPlus() {
		this.row++;
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
	 * Permet de recuperer l'objet board
	 * 
	 * @return return l'objet board
	 */
	public Board getBoard() {
		return this.board;
	}
}