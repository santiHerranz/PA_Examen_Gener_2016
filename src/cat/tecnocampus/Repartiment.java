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
        for (int i = 0; i < result.length ; i++) {
            result[i] = new Nen("", 1,1, true);
        }

        return result;
    }

    private Joguina[] ompleJoguines(int qJoguines) {

        Joguina[] result = new Joguina[qJoguines];
        for (int i = 0; i < result.length ; i++) {
            result[i] = new Joguina(1,4,7, 1, 1, 2, 2);
        }
        return result;
    }



    public void trobarMillor(int k) { // alma - Exercici 4
        // la K indica el nivell, el nen a gmi se li busca regal
        // la i la joguina
        for (int i = 0; i < joguines.length; i++) {
            if (!marcats[i] && acceptable(joguines[i], nens[k])) {
                marcats[k] = true;
                sol[k] = joguines[i];
                if (k == nens.length) {
                    // fulla de l'arbre
                    if (esMillor()) {
                        for (int m = 0; m < nens.length; m++)
                            millor[m] = sol[m];
                        for (int m = 0; m < marcats.length; m++)
                            marcatsMillor[m] = marcats[m];
                    }
                } else
                    trobarMillor(k + 1);
                marcats[k] = false;
                sol[k] = null;
            }
        }
    }

    private boolean acceptable(Joguina joguina, Nen nen) {

        boolean sexe = (nen.getMascle() && joguina.getSexe() != 1) ||
                (!nen.getMascle() && joguina.getSexe() != 0);
        return sexe && nen.getEdat() >= joguina.getEdatMaxim()
                && nen.getEdat() <= joguina.getEdatMinima()
                && nen.getSentit() == joguina.getSentit1()
                || nen.getSentit() == joguina.getSentit2();
    }

    private boolean esMillor() {

        int suma = 0;
        for (int i = 0; i < marcats.length; i++)
            if (!marcats[i])
                suma += joguines[i].getGrauIdonietat();
        if (idonietatMillor < suma) {
            idonietatMillor = suma;
            return true;
        }
        return false;
    }

}

