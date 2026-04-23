import java.util.ArrayList;

public class calculatricestat {

    // Cette méthode reçoit les données du CSV et calcule les statistiques pour chaque colonne
    public ArrayList<String[]> calcule(ArrayList<String[]> rows) {

        // Créer une liste vide pour stocker les résultats
        ArrayList<String[]> resultat = new ArrayList<>();

        // Si les données sont vides ou contiennent seulement un en-tête, arrêter ici
        if (rows == null || rows.size() < 2) {
            System.out.println("ajoute plus de donnees.");
            return resultat;
        }

        // La première ligne contient les noms des colonnes (en-tête)
        String[] headers = rows.get(0);

        // Compter le nombre de colonnes
        int cols = headers.length;

        // Compter le nombre de lignes valides traitées
        int lignes = 0;

        // Tableaux pour stocker la somme, le minimum et le maximum de chaque colonne
        double[] sums = new double[cols];
        double[] mins = new double[cols];
        double[] maxs = new double[cols];

        // Initialiser les mins à la valeur la plus haute possible et les maxs à la plus basse
        // pour que n'importe quelle valeur réelle les remplace
        for (int i = 0; i < cols; i++) {
            mins[i] = Double.MAX_VALUE;
            maxs[i] = -Double.MAX_VALUE;
        }

        // Parcourir chaque ligne de données en commençant à la ligne 1 (ignorer l'en-tête)
        for (int r = 1; r < rows.size(); r++) {
            String[] row = rows.get(r);

            // Ignorer les lignes qui n'ont pas le bon nombre de colonnes
            if (row.length != cols) {
                System.out.println("colonne invalide");
                continue;
            }

            // Supposer que la ligne est valide jusqu'à preuve du contraire
            boolean validRow = true;
            double[] nums = new double[cols];

            // Essayer de convertir chaque valeur de la ligne en nombre
            for (int c = 0; c < cols; c++) {
                try {
                    nums[c] = Double.parseDouble(row[c].trim());
                } catch (NumberFormatException e) {
                    // Si une valeur n'est pas un nombre, marquer la ligne comme invalide
                    validRow = false;
                    break;
                }
            }

            // Ignorer la ligne si elle contient des valeurs non numériques
            if (!validRow) {
                System.out.println("valeur non numerique.");
                continue;
            }

            // Compter cette ligne comme valide
            lignes++;

            // Mettre à jour la somme, le minimum et le maximum pour chaque colonne
            for (int c = 0; c < cols; c++) {
                double v = nums[c];
                sums[c] += v;
                if (v < mins[c]) mins[c] = v;
                if (v > maxs[c]) maxs[c] = v;
            }
        }

        // Si aucune ligne valide n'a été trouvée, arrêter ici
        if (lignes == 0) {
            System.out.println("aucune ligne valide.");
            return resultat;
        }

        // Calculer la moyenne pour chaque colonne et stocker les résultats
        for (int c = 0; c < cols; c++) {
            double avg = sums[c] / lignes;

            // Chaque ligne de résultat contient : nom de colonne, moyenne, min, max
            String[] statRow = new String[4];
            statRow[0] = headers[c].trim();
            statRow[1] = String.valueOf(avg);
            statRow[2] = String.valueOf(mins[c]);
            statRow[3] = String.valueOf(maxs[c]);
            resultat.add(statRow);
        }

        // Retourner la liste des statistiques
        return resultat;
    }
}