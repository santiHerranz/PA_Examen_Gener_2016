package cat.tecnocampus;

public class Nen {

    public static final int OIDA=1;
    public static final int OLFAT=2;
    public static final int VISTA=3;
    public static final int GUST=4;
    public static final int TACTE=5;

    private String nom;
    private int edat;
    private int sentit; //que es vol estimular
    private boolean mascle;

    public Nen(String nom, int edat, int sentit, boolean mascle){
        this.nom=nom;
        this.edat=edat;
        this.sentit=sentit;
        this.mascle=mascle;
    }
    public String getNom(){return nom;}
    public int getEdat(){return edat;}
    public int getSentit(){return sentit;}
    public boolean getMascle(){return mascle;}

    @Override
    public String toString() {
        return nom +"("+ edat +")";
    }
}
