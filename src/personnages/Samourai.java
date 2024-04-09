package personnages;

public class Samourai extends Ronin {
	private String seigneur;

	public Samourai(String seigneur, String nom, String boissonFav, int argent) {
		super(nom, boissonFav, argent);
		this.seigneur = seigneur;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		StringBuilder s = new StringBuilder();
		s.append("Je suis fier de servir le seigneur ");
		s.append(seigneur);
		s.append(".");
		parler(s.toString());
	}

	public void boire(String boisson) {
		StringBuilder s = new StringBuilder();
		s.append("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du ");
		s.append(boisson);
		s.append(".");
		parler(s.toString());
	}

}
