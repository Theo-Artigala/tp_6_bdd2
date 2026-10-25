package tp.ecole.model;

/**
 * POJO représentant un résultat (inscription + note) de la base RESULTATS.
 *
 * Schéma SQL de référence :
 *   NUM_ELEVE  NUMERIC(6)  PK, FK -> ELEVES
 *   NUM_COURS  NUMERIC(4)  PK, FK -> COURS
 *   POINTS     NUMERIC(3)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés (numEleve, numCours, points).
 *      Vous pouvez également ajouter des champs calculés ou enrichis
 *      (ex. nomCours, nomEleve) pour faciliter l'affichage.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher le résultat de façon lisible.
 *
 * =====================================================================
 */
public class Resultat {

    // Attributs (un par colonne de la table RESULTATS)
    private int numEleve;
    private int numCours;
    // Double (et pas double) car la note peut être NULL en base
    // (quand l'élève est inscrit mais pas encore noté)
    private Double points;

    // Constructeur par défaut (vide)
    public Resultat() {
    }

    // Constructeur avec tous les paramètres
    public Resultat(int numEleve, int numCours, Double points) {
        this.numEleve = numEleve;
        this.numCours = numCours;
        this.points = points;
    }

    // Getters et setters

    public int getNumEleve() {
        return numEleve;
    }

    public void setNumEleve(int numEleve) {
        this.numEleve = numEleve;
    }

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    // toString() : pour afficher le résultat de façon lisible
    @Override
    public String toString() {
        return "Resultat [numEleve=" + numEleve
                + ", numCours=" + numCours
                + ", points=" + points + "]";
    }
}
