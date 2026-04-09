package personnages;

public class Yakuza extends Humain {

    private String clan;
    private int reputation;

    public Yakuza(String nom, String boisson, int argent, String clan) {
        super(nom, boisson, argent);
        this.clan = clan;
        this.reputation = 0;
    }

    public void extorquer(Commercant victime) {

        parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
        parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");

        int somme = victime.seFaireExtorquer(); // le commerçant perd tout

        modifierArgent(somme); // le yakuza gagne l'argent
        reputation++; // gagne 1 point de réputation

        parler("J’ai piqué les " + somme + " sous de " + victime.getNom() +
                ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
    }
}