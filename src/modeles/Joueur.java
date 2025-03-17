package modeles;
public abstract class Joueur {
    protected String nom;
    protected int score;
    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }
    public String getNom() {
        return nom;
    }
    public int getScore() {
        return score;
    }
    public void ajoutScore(int points) {
        score += points;
    }
    public abstract Position jouer(Grille grille, int posActif); // Ligne ou colonne active
}
