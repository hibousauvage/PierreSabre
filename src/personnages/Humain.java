package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;

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

	protected void parler(String texte) {
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
			sb.append("j'ai ");
			sb.append(argent);
			sb.append(" sous en poche. Je vais pouvoir m'offrir ");
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

}
