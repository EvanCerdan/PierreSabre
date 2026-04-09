package personnages;

public class Commercant extends Humain {

    // Constructeur : boisson imposée = thé
    public Commercant(String nom, int argent) {
        super(nom, "thé", argent);
    }

    // Le commerçant se fait extorquer
    public int seFaireExtorquer() {
        int somme = getArgent(); // argent avant perte

        parler("J’ai tout perdu! Le monde est trop injuste...");

        modifierArgent(-somme); // il perd tout

        return somme;
    }

    // Le commerçant reçoit de l'argent
    public void recevoir(int argent) {
        parler(argent + " sous ! Je te remercie généreux donateur!");
        modifierArgent(argent);
    }
}