package modeles;
import java.util.List;
import java.util.Scanner;

import modeles.Grille;
import modeles.Joueur;

public class JoueurHumain extends Joueur {
    public JoueurHumain(String nom) {
        super(nom);
    }

    @Override
    public Position jouer(Grille grille, int posActif) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrer la position la ligne puis la colonne: "+nom);
        int ligne = scanner.nextInt();
        int colonne = scanner.nextInt();
        return new Position(ligne, colonne);
    }
}

