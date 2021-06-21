package model;

public class Machine extends Batiment {

	private int pierreReward = 0;
	private int boisReward = 0;
	private int savoirReward = 0;
	private int tuileReward = 0;

	/**
	 * Constructeur de Machine
	 * 
	 * @param nom    le nom du batiment
	 * @param bois   le nombre de bois
	 * @param pierre le nombre de pierre
	 * @param tuile  le nombre de tuile
	 * @param savoir le nombre de savoir
	 * @param pointV le nombre de points de victoire
	 * @param ecus   le nombre d'ecus
	 */
	public Machine(String nom, int bois, int pierre, int tuile, int savoir, int pointV, int pierreReward,
			int boisReward, int savoirReward, int tuileReward) {
		super(nom, bois, pierre, tuile, savoir, pointV, 0);
	}

	public int getAmountBois() {
		return boisReward;

	}

	public int getAmountPierre() {
		return pierreReward;
	}

	public int getAmountSavoir() {
		return savoirReward;
	}

	public int getAmountTuile() {
		return tuileReward;
	}

	public void print() {
		System.out.println("Machine(nom : " + this.getNom() + ", bois : " + this.getBois() + ", pierre : "
				+ this.getPierre() + ", tuile : " + this.getTuile() + ", savoir : " + this.getSavoir() + ", ecus : "
				+ this.getEcus() + ", bois gagne : " + this.boisReward + ", pierre gagne : " + this.pierreReward
				+ ", savoir gagne : " + this.savoirReward + ", tuile gagne : " + this.tuileReward);
	}
}