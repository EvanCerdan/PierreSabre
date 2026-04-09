package personnages;

public class Humain {
    private String nom;
    private String boisson;
    private int argent;

    // Constructeur
    public Humain(String nom, String boisson, int argent) {
        this.nom = nom;
        this.boisson = boisson;
        this.argent = argent;
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
        parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
    }
    
    public void boire() {
        parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
    }
    
    private void gagnerArgent(int gain) {
        argent += gain;
    }

    private void perdreArgent(int perte) {
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
    
}
    
