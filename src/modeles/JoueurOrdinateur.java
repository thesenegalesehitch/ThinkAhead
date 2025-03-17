package modeles;
import java.util.List;
import java.util.Random;

public class JoueurOrdinateur extends Joueur {
    public JoueurOrdinateur(String nom) {
        super(nom);
    }

    @Override
    public Position jouer(Grille grille, int posActif) {
        Random random = new Random();
        List<Position> positionLibres = grille.positionLibreDansLine(posActif);
        if (positionLibres.isEmpty()) {
            return null; //aucun coup possible
        }
        return positionLibres.get(random.nextInt(positionLibres.size()));
    }
}
