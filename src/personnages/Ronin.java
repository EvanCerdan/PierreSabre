package personnages;

public class Ronin extends Humain {

    private int honneur;

    public Ronin(String nom, String boisson, int argent) {
        super(nom, boisson, argent);
        this.honneur = 1;
    }

    public void donner(Commercant beneficiaire) {

        int don = getArgent() / 10;

        parler(beneficiaire.getNom() + " prend ces " + don + " sous.");

        modifierArgent(-don); // le ronin perd l'argent
        beneficiaire.recevoir(don); // le commerçant reçoit
    }
    
    public void provoquer(Yakuza adversaire) {

        parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");

        int force = honneur * 2;

        if (force >= adversaire.getReputation()) {
            // le ronin gagne
            parler("Je t’ai eu petit yakusa!");

            int gain = adversaire.perdre(); // récupère l'argent
            modifierArgent(gain);
            honneur++;

        } else {
            // le ronin perd
            parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");

            int perte = getArgent();
            modifierArgent(-perte);
            honneur--;

            adversaire.gagner(perte);
        }
    }
}