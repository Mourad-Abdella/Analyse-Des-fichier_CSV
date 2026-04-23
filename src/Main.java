import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Demander à l'utilisateur le nom du fichier à analyser
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du fichier CSV: ");
        String input = scanner.nextLine();

        // Nom du fichier de rapport de sortie
        String output = "resume.csv";

        // Créer une instance de chaque classe
        Analyse reader = new Analyse();
        calculatricestat calculator = new calculatricestat();
        rapport writer = new rapport();

        //  Lire le fichier CSV
        ArrayList<String[]> rows = reader.lireCSV(input);

        // Si le fichier est vide ou introuvable, arrêter le programme
        if (rows.isEmpty()) {
            System.out.println("fichier vide ou introuvable");
            return;
        }

        // Calculer les statistiques
        ArrayList<String[]> stats = calculator.calcule(rows);

        // Si aucune statistique n'a été produite, arrêter le programme
        if (stats.isEmpty()) {
            System.out.println("rien a afficher");
            return;
        }

        // Afficher les résultats dans la console
        System.out.println("---- VOTRE RESULTAT-----");
        for (String[] s : stats) {
            System.out.println("Colonne: " + s[0]);
            System.out.println("  Moyenne: " + s[1]);
            System.out.println("  Min: " + s[2]);
            System.out.println("  Max: " + s[3]);
            System.out.println();
        }

        //  Sauvegarder les résultats dans un fichier CSV
        writer.ecrireCSV(output, stats);
    }
}
