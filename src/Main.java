import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        String input = "data.csv";
        String output = "resume.csv";

        Analyse reader = new Analyse();
        calculatricestat calculator = new calculatricestat();
        rapport writer = new rapport();

        ArrayList<String[]> rows = reader.lireCSV(input);

        if (rows.isEmpty()) {
            System.out.println("ficher vide out introuvable");
            return;
        }
        ArrayList<String[]> stats = calculator.calcule(rows);

        if (stats.isEmpty()) {
            System.out.println("rien a afficher");
            return;
        }
        System.out.println("---- VOTRE RESULTAT-----");
        for (String[] s : stats) {
            System.out.println("Colonne: " + s[0]);
            System.out.println("  Moyenne: " + s[1]);
            System.out.println("  Min: " + s[2]);
            System.out.println("  Max: " + s[3]);
            System.out.println();
        }

        writer.ecrireCSV(output,stats);
        }
    }