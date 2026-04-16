package personnages;

public class Humain {
    private String nom;
    private String boissonFavorite;
    private int argent;
    protected Humain[] memoire;
    protected int nbConnaissance;

    private static final int TAILLE_MEMOIRE = 30;

    // Constructeur
    public Humain(String nom, String boissonFavorite, int argent) {
        this.nom = nom;
        this.boissonFavorite = boissonFavorite;
        this.argent = argent;
        this.memoire = new Humain[TAILLE_MEMOIRE];
        this.nbConnaissance = 0;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getArgent() {
        return argent;
    }
    
    // Méthodes 
    // remplacement de private void parler 
    protected void parler(String texte) {
        System.out.println("(" + nom + ") - " + texte);
    }
    
    public void direBonjour() {
        parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
    }
    
    public void boire() {
        parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
    }
    
    protected void gagnerArgent(int gain) {
        argent += gain;
    }

    protected void perdreArgent(int perte) {
        argent -= perte;
    }
    
    public void acheter(String bien, int prix) {
        parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");

        if (argent >= prix) {
            perdreArgent(prix);
            if (bien.equals("une boisson")) {
                boire();
            }
        } else {
            parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
        }
    }
    
    protected void modifierArgent(int variation) {
        if (variation > 0) {
            gagnerArgent(variation);
        } else if (variation < 0) {
            perdreArgent(-variation);
        }
    }
    
    // TP 5 
    protected void memoriser(Humain h) {
        // Si mémoire pleine → on décale tout à gauche
        if (nbConnaissance == TAILLE_MEMOIRE) {
            for (int i = 0; i < TAILLE_MEMOIRE - 1; i++) {
                memoire[i] = memoire[i + 1];
            }
            memoire[TAILLE_MEMOIRE - 1] = h;
        } else {
            memoire[nbConnaissance] = h;
            nbConnaissance++;
        }
    }
    
    public void listerConnaissance() {
        StringBuilder liste = new StringBuilder();

        for (int i = 0; i < nbConnaissance; i++) {
            liste.append(memoire[i].getNom());
            if (i < nbConnaissance - 1) {
                liste.append(", ");
            }
        }

        parler("Je connais beaucoup de monde dont : " + liste.toString());
    }
    
    private void repondre(Humain h) {
        direBonjour();
        memoriser(h);
    }
    
    public void faireConnaissanceAvec(Humain autreHumain) {
        direBonjour();
        autreHumain.repondre(this);
        memoriser(autreHumain);
    }
    
    
    
}
    
