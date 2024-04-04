package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFav, int argent) {
		super(nom, boissonFav, argent);
	}

	public void provoquer(Yakuza adversaire) {
		if (honneur >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			gagnerArgent(adversaire.perdre());
			honneur++;

		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
			honneur--;

		}
	}

	public void donner(Commercant beneficiaire) {
		int don = getArgent() / 10;
		perdreArgent(don);
		StringBuilder s = new StringBuilder();
		s.append(beneficiaire.getNom());
		s.append(" prend ces ");
		s.append(don);
		s.append(" sous.");
		parler(s.toString());
		beneficiaire.recevoir(don);
	}

}
