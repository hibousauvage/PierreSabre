package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFav, int argent) {
		super(seigneur, nom, boissonFav, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		StringBuilder s = new StringBuilder();
		s.append("Mais je suis un traitre et mon niveau de traitrise est : ");
		s.append(niveauTraitrise);
		s.append(". Chut !");
		parler(s.toString());
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			StringBuilder s = new StringBuilder();
			s.append("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi ");
			s.append(argentRanconner);
			s.append(" sous ou gare a toi !");
			parler(s.toString());
			StringBuilder scom = new StringBuilder();
			scom.append("Tout de suite grand ");
			scom.append(getNom());
			scom.append(".");
			commercant.parler(scom.toString());
		} else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasque !");
		}
	}

	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Random gen = new Random();
			int nb = gen.nextInt(nbConnaissance);
			Humain ami = memoire[nb];
			int don = getArgent() * 1 / 20;
			String nomAmi = ami.getNom();
			StringBuilder s = new StringBuilder();
			s.append("il fait absolument remonter ma cote de confiance. Je vais faire ami ami avec ");
			s.append(nomAmi);
			s.append(".");
			parler(s.toString());

			if (niveauTraitrise > 1) {
				niveauTraitrise--;
			}
		}

	}

}
