package modetext;
import modeles.*;
public class JeuTexte {
    public static void main(String[] args) {
        Joueur j1 = new JoueurHumain("Big Lex");
        Joueur j2 = new JoueurOrdinateur("ordinateur");
        Partie partie = new Partie(j1, j2, 4); //ici on cree une grille de 4lignes et de 4colonnes
        partie.commencerPartie();
    }
}
