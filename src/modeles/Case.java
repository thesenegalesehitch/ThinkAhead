package modeles;
public class Case {
    private int val;
    private boolean caseSelectionnee;

    public Case(int val) {
        this.val = val;
        this.caseSelectionnee = false;
    }

    public int getVal() {
        return val;
    }

    public boolean caseSelectionnee() {
        return caseSelectionnee;
    }

    public void selectionner() {
        caseSelectionnee = true;
    }

    @Override
    public String toString() {
        return caseSelectionnee ? "A" : String.valueOf(val);
    }
}

