import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Analyse {

    // Cette méthode lit un fichier CSV et retourne son contenu sous forme de liste de lignes
    public ArrayList<String[]> lireCSV(String Chemin) {

        // Créer une liste vide pour stocker les lignes
        ArrayList<String[]> rows = new ArrayList<>();

        // Ouvrir le fichier pour la lecture
        try (BufferedReader br = new BufferedReader(new FileReader(Chemin))) {
            String Ligne;

            // Lire le fichier ligne par ligne jusqu'à la fin
            while ((Ligne = br.readLine()) != null) {

                // Ignorer les lignes vides
                if (!Ligne.trim().isBlank()) {

                    // Séparer la ligne par les virgules et la stocker comme tableau
                    String[] values = Ligne.split(",");
                    rows.add(values);
                }
            }

        // Si le fichier est introuvable ou illisible, afficher l'erreur
        } catch (IOException e) {
            System.out.println("erreur:" + e.getMessage());
        }

        // Retourner la liste complète des lignes
        return rows;
    }
}