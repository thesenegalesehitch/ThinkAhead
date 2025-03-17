package modetext;
import modeles.*;
public class JeuTexte {
    public static void main(String[] args) {
        Joueur p1 = new JoueurHumain("Big Lex");
        Joueur p2 = new JoueurOrdinateur("ordinateur");
        Partie partie = new Partie(p1, p2, 4); //ici on cree une grille de 4lignes et de 4colonnes
        partie.commencerPartie();
    }
}
