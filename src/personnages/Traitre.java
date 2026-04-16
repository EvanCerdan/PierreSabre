package personnages;

import java.util.Random;

public class Traitre extends Samourai {

    private int niveauTraitre;
    private Random random;

    public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
        super(seigneur, nom, boissonFavorite, argent);
        this.niveauTraitre = 0;
        this.random = new Random();
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        parler("Mais je suis un traître et mon niveau de traîtrise est : "
                + niveauTraitre + ". Chut !");
    }

    public void ranconner(Commercant c) {

        if (niveauTraitre >= 3) {
            parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
            return;
        }

        int somme = c.getArgent() / 5;

        parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer !");
        parler("Donne-moi " + somme + " sous ou gare à toi !");

        c.perdreArgent(somme);
        this.gagnerArgent(somme);

        niveauTraitre++;
    }

    public void faireLeGentil() {

        if (nbConnaissance == 0) {
            parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
            return;
        }

        int index = random.nextInt(nbConnaissance);
        Humain cible = memoire[index];

        int don = getArgent() / 20;

        parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "
                + cible.getNom() + ".");
        parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");

        this.perdreArgent(don);
        cible.gagnerArgent(don);

        if (niveauTraitre > 0) {
            niveauTraitre--;
        }
    }
}