package modeles;
public class Partie {
    private Grille grille;
    private Joueur p1;
    private Joueur p2;
//ligne ou colonne active
    private int posActif; 
    private boolean ligneActif;
public Partie(Joueur p1, Joueur p2, int tailleGrille) {
        this.grille = new Grille(tailleGrille);
        this.p1 = p1;
        this.p2 = p2;
        this.posActif = 0; //ligne 0 active au dbut
        this.ligneActif = true;
}
public void commencerPartie() {
    Joueur joueurActif = p1;
        while (true) {
            grille.afficherGrille();
            System.out.println("Score " + p1.getNom() + " : " + p1.getScore());
            System.out.println("Score " + p2.getNom() + " : " + p2.getScore());
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
            joueurActif = (joueurActif == p1) ? p2 : p1;
    }}
}
