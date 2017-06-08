package cat.tecnocampus;

public class Main {

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
