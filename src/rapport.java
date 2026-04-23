import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class rapport {

    // Cette méthode écrit les statistiques dans un fichier CSV
    public void ecrireCSV(String output, ArrayList<String[]> stats) {

        // Ouvrir le fichier de sortie pour l'écriture
        try (FileWriter fw = new FileWriter(output)) {

            // Écrire la ligne d'en-tête du fichier CSV de sortie
            fw.write("colonne,moyenne,minimum,maximum\n");

            // Écrire une ligne par colonne avec ses statistiques
            for (String[] row : stats) {
                fw.write(row[0] + "," + row[1] + "," + row[2] + "," + row[3] + "\n");
            }

            System.out.println("rapport cree:" + output);

        // Si le fichier ne peut pas être écrit, afficher l'erreur
        } catch (IOException e) {
            System.out.println("erreur d'ecriture du rapport: " + output);
        }
    }
}
