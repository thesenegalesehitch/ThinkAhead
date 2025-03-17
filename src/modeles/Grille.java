package modeles;
import java.util.ArrayList;
import java.util.List;
public class Grille{
    private Case[][] cases;
    public Grille(int taille) {
        cases = new Case[taille][taille];
        initGrille();
    }
    private void initGrille() {
        for (int i=0;i<cases.length;i++) {
            for (int j=0; j<cases[i].length;j++) {
                cases[i][j] = new Case((int) (Math.random()*10)); 
            }
        }
    }
    public List<Position> positionLibreDansLine(int ligne) {
        List<Position> positionLibres = new ArrayList<>();
        for (int j=0;j<cases[ligne].length;j++) {
            if (!cases[ligne][j].caseSelectionnee()) {
                positionLibres.add(new Position(ligne, j));
            }
        }return positionLibres;
}
    public List<Position> positionLibreDansColonne(int colonne) {
        List<Position> positionLibres = new ArrayList<>();
        for (int i=0;i<cases.length;i++) {
            if (!cases[i][colonne].caseSelectionnee()) {
                positionLibres.add(new Position(i, colonne));
        }
    }return positionLibres;
    }
    public void afficherGrille() {
        for (int i=0;i<cases.length;i++) {
            for (int j=0;j<cases[i].length;j++) {
                System.out.print(cases[i][j] + " ");
            }
            System.out.println();}
    }
    public Case getCase(Position position) {
        return cases[position.getLigne()][position.getColonne()];}
}
