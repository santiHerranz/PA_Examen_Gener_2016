package cat.tecnocampus;

public class Main {

    // S’han de prendre decisions i tenir la possibilitat de desdir-te’n.
    // La solució la podem expressar com una seqüència de decisions.
    // En cada nivell assignem a un nen una joguina,
    // per tant la pregunta al nivell n-èssim serà: ”al nen n-èssim quina joguina li assignem”.
    // L’alçada de l’espai de cerca serà exacta i es correspondrà al número de nens hospitalitzats.
    // L’amplada serà màxima i vindrà donada pel número màxim de regals. Amb aquest plantejament cal usar
    // marcatge per no repetir-se les joguines. Totes les solucions deixaran exactament el mateix
    // número de joguines sense assignar, però la millor solució és la que maximitza la idoneïtat de
    // les que queden lliures. Per ser solució s’ha d’arribar a una fulla de l’arbre i les assignacions
    // han de complir les restriccions indicades en l’enunciat: sexe, edat i sentit.
    // No sempre hi haurà solució.

    public static void main(String[] args) {

        System.out.println("Quantes joguines tenim?");
        int qJoguines = Keyboard.readInt();
        System.out.println("Quants nens tenim?");
        int qNens = Keyboard.readInt();
        Repartiment r = new Repartiment(qJoguines, qNens);

        // TODO Exercici 3

        r.trobarMillor(0);
        if (r.idonietatMillor == -1)
            System.out.println("No hi ha solució");
        else
            System.out.println(r);
    }
}
