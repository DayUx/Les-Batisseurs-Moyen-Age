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
		this.pierreReward = pierreReward;
		this.tuileReward = tuileReward;
		this.boisReward = boisReward;
		this.savoirReward = savoirReward;
	}

	/**
	 * permet de recuperer le nombre de bois que la machine peut "produire"
	 * 
	 * @return le nombre de bois que la machine peut "produier"
	 */
	public int getAmountBois() {
		return boisReward;

	}

	/**
	 * permet de recuperer le nombre de pierre que la machine peut "produire"
	 * 
	 * @return le nombre de pierre que la machine peut "produier"
	 */
	public int getAmountPierre() {
		return pierreReward;
	}

	/**
	 * permet de recuperer le nombre de savoir que la machine peut "produier"
	 * 
	 * @return le nombre de savoir que la machine peut "produier"
	 */
	public int getAmountSavoir() {
		return savoirReward;
	}

	/**
	 * permet de recuperer le nombre de tuile que la machine peut "produier"
	 * 
	 * @return le nombre de tuile que la machine peut "produier"
	 */
	public int getAmountTuile() {
		return tuileReward;
	}

	/**
	 * permet de print les infos d'une machine
	 */
	public void print() {
		System.out.println("Machine(nom : " + this.getNom() + ", bois : " + this.getBois() + ", pierre : "
				+ this.getPierre() + ", tuile : " + this.getTuile() + ", savoir : " + this.getSavoir() + ", ecus : "
				+ this.getEcus() + ", bois gagne : " + this.boisReward + ", pierre gagne : " + this.pierreReward
				+ ", savoir gagne : " + this.savoirReward + ", tuile gagne : " + this.tuileReward + ", points :"
				+ getPointVictoire());
	}
}