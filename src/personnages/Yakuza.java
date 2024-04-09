package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFav, int argent, String clan) {
		super(nom, boissonFav, argent);
		this.clan = clan;

	}

	public int perdre() {
		int argentPerdu = getArgent();
		perdreArgent(getArgent());
		reputation--;

		StringBuilder s = new StringBuilder();
		s.append("j'ai perdu mon duel et mes ");
		s.append(argentPerdu);
		s.append(" sous, snif... J'ai déshonoré le clan de ");
		s.append(clan);
		parler(s.toString());

		return argentPerdu;
	}

	public int getReputation() {
		return reputation;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		StringBuilder s = new StringBuilder();
		s.append("Ce ronin pensait vraiment battre Yaku Le Noir du clan ");
		s.append(clan);
		s.append(" ? Je l'ai depouille de ses 54 sous.");
		parler(s.toString());
	}

	public void extorquer(Commercant victime) {

		parler(victime.getNom() + ", si tu tiens à la vie, donne moi ta bourse !");
		int argentVoler = victime.seFaireExtorquer();
		gagnerArgent(argentVoler);
		reputation++;
		StringBuilder s = new StringBuilder();
		s.append("J'ai pique les ");
		s.append(argentVoler);
		s.append(" sous de ");
		s.append(victime.getNom());
		s.append(", ce qui me fait ");
		s.append(getArgent());
		s.append(" sous dans ma poche. Hi ! Hi !");
		parler(s.toString());
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		StringBuilder s = new StringBuilder();
		s.append("Mon clan est celui de ");
		s.append(clan);
		s.append(".");
		parler(s.toString());
	}
}
