package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
	 * 
	 * 
	 */
	public void play() {
		print();
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
			drawOuvrier();
			play();
		} else if (in == 6) {
			drawBatiment();
			play();
		} else if (in == 7) {
			startChantier();
			play();
		} else if (in == 8) {
			engagerSurChantier();
			play();

		} else if (in == 9) {
			int free = this.getFreeMove();
			if (free == 1) {
				this.setEcus(this.getEcus() + 1);
			} else if (free == 2) {
				this.setEcus(this.getEcus() + 3);

			} else if (free == 3) {
				this.setEcus(this.getEcus() + 6);

			}
			this.resetFreeMove();
		} else if (in == 10) {
			try {
				FileOutputStream fout = new FileOutputStream("../data/test.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(this.getBoard().getGame());
			} catch (IOException e) {
				System.err.println(e);
			}

		}
	}

	/**
	 * permet de piocher une carte ouvrier
	 */
	public void drawOuvrier() {
		if (this.getFreeMove() > 0) {
			useFreeMove();

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
		} else if (this.getEcus() > 5) {
			setEcus(getEcus() - 5);
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
		} else {
			System.out.println("Vous ne possedez pas assez d'écus");
		}
		this.getBoard().fillDecks();
	}

	/**
	 * permet de lancer un chantier
	 */
	public void startChantier() {
		if (this.getFreeMove() > 0) {

			if (this.getBatiments().size() != 0) {
				useFreeMove();
				System.out.println("#####################################################");
				System.out.println("Saisissez le numero du chantier que vous voulez commencer");
				System.out.println();
				this.printBuildings();
				System.out.println("#####################################################");
				int index = -1;
				while (index < 0 || index >= this.getBatiments().size()) {
					index = Input.getInt();
				}
				this.addChantier(this.getBatiments().remove(index));
			} else {
				System.out.println("Vous ne possedez pas de batiments");
			}
		} else if (this.getEcus() > 5) {
			if (this.getBatiments().size() != 0) {
				setEcus(getEcus() - 5);

				System.out.println("#####################################################");
				System.out.println("Saisissez le numero du chantier que vous voulez commencer");
				System.out.println();
				this.printBuildings();
				System.out.println("#####################################################");
				int index = -1;
				while (index < 0 || index >= this.getBatiments().size()) {
					index = Input.getInt();
				}
				this.addChantier(this.getBatiments().remove(index));
			} else {
				System.out.println("Vous ne possedez pas de batiments");
			}
		} else {
			System.out.println("Vous ne possedez pas assez d'écus");
		}

	}

	/**
	 * permet de tirer une carte batiment
	 */
	public void drawBatiment() {
		if (this.getFreeMove() > 0) {
			useFreeMove();
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
		} else if (this.getEcus() > 5) {
			setEcus(getEcus() - 5);
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
		} else {
			System.out.println("Vous ne possedez pas assez d'écus");
		}
		this.getBoard().fillDecks();
	}

	/**
	 * Permet de print les instructions
	 */
	public void printInstructions() {
		System.out.println("#########################################################");
		System.out.println("# 1. Afficher vos cartes ouvriers						");
		System.out.println("# 2. Afficher vos cartes batiments						");
		System.out.println("# 3. Afficher les cartes du plateau						");
		System.out.println("# 4. Afficher vos chantiers en cours					");
		System.out.println("# 5. Tirer une carte ouvrier							");
		System.out.println("# 6. Tirer une carte batiment							");
		System.out.println("# 7. Lancer un chantier									");
		System.out.println("# 8. Assigner un travailleur a un chantier				");
		System.out.println("# 9. Passer son tour									");
		System.out.println("# 9. Sauvegarder et quitter la partie					");
		System.out.println("#########################################################");
	}

	/**
	 * permet d'engager un ouvrier sur un chantier
	 */
	public void engagerSurChantier() {

		if (this.getFreeMove() > 0) {
			useFreeMove();
			if (this.getChantiers().size() != 0) {
				if (this.getChantiers().size() != 0) {
					System.out.println("#####################################################");
					System.out.println(
							"Saisissez le numero du chantier auquel vous voulez assigner un nouveau travailleur");
					System.out.println();
					this.printChantiers();
					System.out.println("#####################################################");
					int index = -1;
					while (index < 0 || index >= this.getChantiers().size()) {
						index = Input.getInt();
					}

					System.out.println("#####################################################");
					System.out.println("Saisissez le numero du travailleur que vous voulez faire travailler");
					System.out.println();
					this.printWorkers();
					System.out.println("#####################################################");
					int idx = -1;
					while (idx < 0 || idx >= this.getOuvriers().size()) {
						idx = Input.getInt();
					}

					Ouvrier var = this.getOuvriers().remove(idx);
					int salaire = var.getSalaire();

					if (salaire <= this.getEcus() - 5) {
						var.setTravaillePour(this.getChantiers().get(index));
						this.getWorking().add(var);
						setEcus(getEcus() - salaire);
						this.work(var);
					} else {
						System.out.println("Vous n'avez pass assez d'ecus pour engager cet ouvrier");
					}

				} else {
					System.out.println("Aucun chantier n'est lancé");
				}

			} else {
				System.out.println("Aucun chantier n'est lancé");
			}

		} else if (this.getEcus() > 5)

		{

			if (this.getChantiers().size() != 0) {
				System.out.println("#####################################################");
				System.out
						.println("Saisissez le numero du chantier auquel vous voulez assigner un nouveau travailleur");
				System.out.println();
				this.printChantiers();
				System.out.println("#####################################################");
				int index = -1;
				while (index < 0 || index >= this.getChantiers().size()) {
					index = Input.getInt();
				}

				System.out.println("#####################################################");
				System.out.println("Saisissez le numero du travailleur que vous voulez faire travailler");
				System.out.println();
				this.printWorkers();
				System.out.println("#####################################################");
				int idx = -1;
				while (idx < 0 || idx >= this.getOuvriers().size()) {
					idx = Input.getInt();
				}

				Ouvrier var = this.getOuvriers().remove(idx);
				int salaire = var.getSalaire();

				if (salaire <= this.getEcus() - 5) {
					var.setTravaillePour(this.getChantiers().get(index));
					this.getWorking().add(var);
					setEcus(getEcus() - 5 - salaire);
					this.work(var);

				} else {
					System.out.println("Vous n'avez pass assez d'ecus pour engager cet ouvrier");
				}

			} else {
				System.out.println("Aucun chantier n'est lancé");
			}

		} else {
			System.out.println("Vous n'avez pas assez d'ecus");
		}
		checkWork();

	}
	/*
	 * private void engagerSurChantierFunc() { if (this.getChantiers().size() != 0)
	 * {
	 * System.out.println("#####################################################");
	 * System.out.
	 * println("Saisissez le numero du chantier auquel vous voulez assigner un nouveau travailleur"
	 * ); System.out.println(); this.printChantiers();
	 * System.out.println("#####################################################");
	 * int index = -1; while (index < 0 || index >= this.getChantiers().size()) {
	 * index = Input.getInt(); }
	 * 
	 * System.out.println("#####################################################");
	 * System.out.
	 * println("Saisissez le numero du travailleur que vous voulez faire travailler"
	 * ); System.out.println(); this.printWorkers();
	 * System.out.println("#####################################################");
	 * int idx = -1; while (idx < 0 || idx >= this.getOuvriers().size()) { idx =
	 * Input.getInt(); }
	 * 
	 * Ouvrier var = this.getOuvriers().remove(idx); int salaire = var.getSalaire();
	 * 
	 * if (salaire <= this.getEcus() - 5) {
	 * var.setTravaillePour(this.getChantiers().get(index));
	 * this.getWorking().add(var); setEcus(getEcus() - 5 - salaire); } else {
	 * System.out.println("Vous n'avez pass assez d'ecus pour engager cet ouvrier");
	 * }
	 * 
	 * } else { System.out.println("Aucun chantier n'est lancé"); } }
	 */
}