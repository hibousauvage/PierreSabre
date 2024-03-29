package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFav, int argent, String clan) {
		super(nom, boissonFav, argent);
		this.clan = clan;

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
}
