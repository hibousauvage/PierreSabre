package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	protected int nbConnaissance;
	private static final int TAILLE_MEM = 30;
	protected Humain[] memoire = new Humain[TAILLE_MEM];

	public Humain(String nom, String boissonFav, int argent) {
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFav);
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFav + " ! Gloups !");
	}

	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("je n'ai plus que ");
			sb.append(argent);
			sb.append(" sous en poche. Je ne peut meme pas m'offrir ");
			sb.append(bien);
			sb.append(" à ");
			sb.append(prix);
			sb.append(" sous ");
			parler(sb.toString());
		}
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	private void memoriser(Humain autreHumain) {
		if (nbConnaissance >= TAILLE_MEM) {
			for (int i = 0; i < nbConnaissance - 1; i++) {
				memoire[i] = memoire[i + 1];
			}
			nbConnaissance--;
		}
		memoire[nbConnaissance] = autreHumain;
		nbConnaissance++;
	}

	private void repondre(Humain autreHumain) {
		direBonjour();
		memoriser(autreHumain);

	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}

	public void listerConnaissance() {
		StringBuilder s = new StringBuilder();
		s.append("Je connais beaucoup de monde dont : ");
		for (int i = 0; i < nbConnaissance; i++) {
			s.append(memoire[i].getNom());
			s.append(", ");
		}
		System.out.println(s.toString());
	}

}
