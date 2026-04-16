package histoire;

import personnages.*;

public class HistoireTP5 {

    public static void main(String[] args) {

        Commercant marco = new Commercant("Marco", 20);
        Commercant chonin = new Commercant("Chonin", 40);
        Commercant kumi = new Commercant("Kumi", 10);

        Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");

        Ronin roro = new Ronin("Roro", "shochu", 60);

        // Rencontres
        marco.faireConnaissanceAvec(roro);
        marco.faireConnaissanceAvec(yaku);
        marco.faireConnaissanceAvec(chonin);
        marco.faireConnaissanceAvec(kumi);

        // Affichage des connaissances
        marco.listerConnaissance();
        roro.listerConnaissance();
        yaku.listerConnaissance();
        
        yaku.direBonjour(); 
        
        
     
        Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);

        // Le samouraï se présente
        akimoto.direBonjour();

        // Rencontre
        akimoto.faireConnaissanceAvec(marco);

        // Liste des connaissances
        akimoto.listerConnaissance();
        
        
        akimoto.direBonjour();
        akimoto.boire("thé");
    }
}