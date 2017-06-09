package cat.tecnocampus;

public class Repartiment {

    private Joguina[] joguines;
    private Nen[] nens;

    // atributs
    private Joguina sol[];
    private boolean marcats[];

    private Joguina millor[];
    private boolean marcatsMillor[];

    public int idonietatMillor;

    public Repartiment(int qJoguines, int qNens) {
        joguines = ompleJoguines(qJoguines);
        nens = ompleNens(qNens);
        // omplena Exercici 2
        sol = new Joguina[qNens];
        millor = new Joguina[qNens];
        marcats = new boolean[qJoguines];
        marcatsMillor = new boolean[qJoguines];
        for (int i = 0; i < marcats.length; i++) {
            marcats[i] = false;
            marcatsMillor[i] = false;
        }
        idonietatMillor = -1; // s'ha de maximitzar, el valor minim es 0
    }

    private Nen[] ompleNens(int qNens) {
        Nen[] result = new Nen[qNens];

        if(qNens>0)
            result[0] = new Nen("Jordi", 5,Joguina.GUST, true);

        if(qNens>1)
            result[1] = new Nen("Rosa", 4,Joguina.VISTA, false);

        if(qNens>2)
            result[2] = new Nen("Biel", 4,Joguina.OIDA, true);

        if(qNens>3)
            result[3] = new Nen("Marta", 4,Joguina.OLFAT, true);

        return result;
    }

    private Joguina[] ompleJoguines(int qJoguines) {

        Joguina[] result = new Joguina[qJoguines];

        if(qJoguines>0)
            result[0] = new Joguina(1,2,4, Joguina.GUST, Joguina.TACTE, 2, 2);

        if(qJoguines>1)
            result[1] = new Joguina(2,2,6, Joguina.OIDA, Joguina.OLFAT, 2, 2);

        if(qJoguines>2)
            result[2] = new Joguina(3,2,6, Joguina.GUST, Joguina.OIDA, 3, 2);

        if(qJoguines>3)
            result[3] = new Joguina(4,2,6, Joguina.GUST, Joguina.VISTA, 5, 2);

        if(qJoguines>4)
            result[4] = new Joguina(5,2,6, Joguina.GUST, Joguina.VISTA, 5, 2);

        if(qJoguines>5)
            result[5] = new Joguina(6,3,4, Joguina.VISTA, Joguina.TACTE, 10, 2);

        return result;
    }


    public void trobarMillor(int k) { // alma - Exercici 4
        // la K indica el nivell, el nen a gmi se li busca regal
        // la i la joguina
        for (int i = 0; i < joguines.length; i++) {
            if (!marcats[i])
                if (acceptable(joguines[i], nens[k])) {
                    marcats[i] = true;
                    sol[k] = joguines[i];
                    if (k == nens.length-1) {
                        // fulla de l'arbre
                        esMillor();
                    } else
                        trobarMillor(k + 1);
                    marcats[i] = false;
                    sol[k] = null;
                }
        }
    }

    private boolean acceptable(Joguina joguina, Nen nen) {

        boolean sexe = (nen.getMascle() && joguina.getSexe() == 0)
                || (!nen.getMascle() && joguina.getSexe() == 1)
                || joguina.getSexe() == 2;

        boolean edat = nen.getEdat() >= joguina.getEdatMinima()
                && nen.getEdat() <= joguina.getEdatMaxima();

        boolean sentits = nen.getSentit() == joguina.getSentit1()
                        || nen.getSentit() == joguina.getSentit2();

        return sexe && edat && sentits;
    }

    private void esMillor() {

        int suma = 0;
        for (int i = 0; i < marcats.length; i++)
            if (!marcats[i])
                suma += joguines[i].getGrauIdonietat();

        if (idonietatMillor < suma) {
            // es millor solucio, guardar a taula millor i joguines marcades
            idonietatMillor = suma;

            for (int m = 0; m < sol.length; m++)
                millor[m] = sol[m];
            for (int m = 0; m < marcats.length; m++)
                marcatsMillor[m] = marcats[m];
        }
    }


    @Override
    public String toString() {

        String s = "La solució :\n";
        for (int i = 0; i < millor.length; i++)
            s += "Nen: "+ nens[i] +"\t Joguina: "+ millor[i] +"\n";

        s += "\nEls regals sense assignar:\n";
        for (int i = 0; i < marcatsMillor.length; i++)
            if (!marcatsMillor[i])
                s = s + joguines[i]
                        + " amb un grau de idonietat:"
                        + joguines[i].getGrauIdonietat() +"\n";
        return s;
    }
}

