package personnages;

import java.util.Random;

public class GrandMere extends Humain {

    private static final int TAILLE_MEMOIRE = 5;
    private Random random;

    // Enum interne
    private enum TypeHumain {
        COMMERCANT, RONIN, SAMOURAI, YAKUZA, HABITANT
    }

    public GrandMere(String nom, int argent) {
        super(nom, "tisane", argent);
        this.random = new Random();
    }

    @Override
    protected void memoriser(Humain h) {

        if (nbConnaissance >= TAILLE_MEMOIRE) {
            parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
            return;
        }

        memoire[nbConnaissance] = h;
        nbConnaissance++;
    }

    private String humainHasard() {
        TypeHumain[] types = TypeHumain.values();
        int index = random.nextInt(types.length);

        return types[index].name().toLowerCase();
    }

    public void ragoter() {

        for (int i = 0; i < nbConnaissance; i++) {

            Humain h = memoire[i];

            if (h instanceof Traitre) {
                parler("Je sais que " + h.getNom() + " est un traître. Petit chenapan !");
            } else {
                parler("Je crois que " + h.getNom() + " est un " + humainHasard());
            }
        }
    }
}