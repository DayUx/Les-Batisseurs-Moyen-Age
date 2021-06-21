package model;

import utilitaire.Input;

public class Humain extends Joueur {

	/**
	 * Constructeur de Humain
	 * 
	 * @param nom le nom du joueur
	 */
	public Humain(String nom) {
		super(nom);
	}

	/**
	 * Permet de choisir une action
	 */
	public void play() {
		printInstructions();
		int in = Input.getInt();

		if (in == 1) {
			this.printWorkers();
			play();
		} else if (in == 2) {
			this.printBuildings();
			play();
		} else if (in == 3) {
			this.getBoard().printCards();
			play();
		} else if (in == 4) {
			this.printChantiers();
			play();
		} else if (in == 5) {
			System.out.println("#####################################################");
			System.out.println("Saisissez le numero de la carte que vous voulez tirer");
			System.out.println();
			this.getBoard().printOuv();
			System.out.println("#####################################################");
			int index = -1;
			while (index < 0 || index >= this.getBoard().getCardsOuv().size()) {
				index = Input.getInt();
			}
			this.addOuvrier(this.getBoard().getCardsOuv().remove(index));
			this.getBoard().printCards();
			play();
		} else if (in == 6) {
			System.out.println("#####################################################");
			System.out.println("Saisissez le numero de la carte que vous voulez tirer");
			System.out.println();
			this.getBoard().printBat();
			System.out.println("#####################################################");
			int index = -1;
			while (index < 0 || index >= this.getBoard().getCardsBat().size()) {
				index = Input.getInt();
			}
			this.addBatiment(this.getBoard().getCardsBat().remove(index));
			this.getBoard().printCards();
			play();
		} else if (in == 7) {
			this.printChantiers();
			play();
		}
	}

	public void printInstructions() {
		System.out.println("#########################################################");
		System.out.println("# 1. Afficher vos cartes ouvriers						#");
		System.out.println("# 2. Afficher vos cartes batiments						#");
		System.out.println("# 3. Afficher les cartes du plateau						#");
		System.out.println("# 4. Afficher vos chantiers en cours					#");
		System.out.println("# 5. Tirer une carte ouvrier							#");
		System.out.println("# 6. Tirer une carte batiment							#");
		System.out.println("# 7. Lancer un chantier									#");
		System.out.println("# 8. Passer son tour									#");
		System.out.println("#########################################################");
	}
}