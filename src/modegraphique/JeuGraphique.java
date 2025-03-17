package modegraphique;
import modeles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class JeuGraphique extends JFrame {
    private Grille grille;
    private JButton[][] bouton;
    private Joueur p1;
    private Joueur p2;
    private Joueur joueurActif;
    //ligne ou colonne active
    private int posActif; 
    private boolean ligneActif;

    public JeuGraphique(int tailleGrille) {
        this.grille = new Grille(tailleGrille);
        this.bouton = new JButton[tailleGrille][tailleGrille];
        this.p1 = new JoueurHumain("Alexandre");
        this.p2 = new JoueurOrdinateur("ordinateur");
        this.joueurActif = p1;
        //ligne 0 active au debut
        this.posActif = 0; 
        this.ligneActif = true;
        setTitle("Think Ahead by Alex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(grillePanel(), BorderLayout.CENTER);
        add(infoPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

private JPanel grillePanel() {
    JPanel panel = new JPanel(new GridLayout(bouton.length, bouton.length));
    for(int i=0;i<bouton.length;i++) {
        for (int j=0;j<bouton[i].length;j++) {
            bouton[i][j] = new JButton();
            bouton[i][j].setText(String.valueOf(grille.getCase(new Position(i, j)).getVal()));
            bouton[i][j].setEnabled(false); //activer et ou desactiver selon la ligne ou colonne active
            int finalI=i;
            int finalJ=j;
            bouton[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jouerCoup(new Position(finalI, finalJ));
                    }
                });
                panel.add(bouton[i][j]);
            }}
        activerCaseActive();
        return panel;}
private JPanel infoPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 1));
    JLabel infos = new JLabel("joueur actif: " + joueurActif.getNom());
    infos.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(infos);
    JLabel scores = new JLabel("scores: " + p1.getNom() + ": " + p1.getScore() + ", " + p2.getNom() + ": " + p2.getScore());
    scores.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(scores);
    return panel;}
private void activerCaseActive() {
    for (int i = 0; i < bouton.length; i++) {
        for (int j = 0; j < bouton[i].length; j++) {
            bouton[i][j].setEnabled(false);
            if (ligneActif && i == posActif && !grille.getCase(new Position(i, j)).caseSelectionnee()) {
                bouton[i][j].setEnabled(true);
            } else if (!ligneActif && j == posActif && !grille.getCase(new Position(i, j)).caseSelectionnee()) {
                bouton[i][j].setEnabled(true);
                }}
    } 
}
private void jouerCoup(Position position){
    Case caseJouee = grille.getCase(position);
    caseJouee.selectionner();
    joueurActif.ajoutScore(caseJouee.getVal());
        bouton[position.getLigne()][position.getColonne()].setText("A");
        bouton[position.getLigne()][position.getColonne()].setEnabled(false);
        //met a jour l'index actif et soit la ligne soit la colonne
        posActif = ligneActif ? position.getColonne() : position.getLigne();
        ligneActif = !ligneActif;
        //change le joueur actif
        joueurActif = (joueurActif == p1) ? p2 : p1;
        activerCaseActive();
        //verifie si le jeu est termine
        finPartie();
    }
private void finPartie(){
    boolean aucunCoupPosible = true;
    for (int i=0;i<bouton.length;i++) {
        for (int j=0;j<bouton[i].length;j++) {
            if (bouton[i][j].isEnabled()) {
                aucunCoupPosible = false;
                break;}
    }
}
    if (aucunCoupPosible){
        JOptionPane.showMessageDialog(this, "fin de la partie \n" +
                p1.getNom() + ": " + p1.getScore() + " pts\n" +
                p2.getNom() + ": " + p2.getScore() + " pts");
            System.exit(0);
        }
}
public static void main(String[] args){
     new JeuGraphique(4); //ici on cree une grille 4ligne et 4colonnes
    }
}
