package modeles;
public class Partie {
    private Grille grille;
    private Joueur j1;
    private Joueur j2;
//ligne ou colonne active
    private int posActif; 
    private boolean ligneActif;
public Partie(Joueur j1, Joueur j2, int tailleGrille) {
        this.grille = new Grille(tailleGrille);
        this.j1 = j1;
        this.j2 = j2;
        this.posActif = 0; //ligne 0 active au dbut
        this.ligneActif = true;
}
public void commencerPartie() {
    Joueur joueurActif = j1;
        while (true) {
            grille.afficherGrille();
            System.out.println("Score " + j1.getNom() + " : " + j1.getScore());
            System.out.println("Score " + j2.getNom() + " : " + j2.getScore());
            Position position = joueurActif.jouer(grille, posActif);
            if (position == null) {
                System.out.println("aucun coup possible");
                System.out.println("fin de la partie");
                break;}
            Case caseJouee = grille.getCase(position);
            caseJouee.selectionner();
            joueurActif.ajoutScore(caseJouee.getVal());
            posActif = ligneActif ? position.getColonne() : position.getLigne();
            ligneActif = !ligneActif;
            joueurActif = (joueurActif == j1) ? j2 : j1;
    }}
}
