package tp.ecole.model;

/**
 * POJO représentant un cours de la base COURS.
 *
 * Schéma SQL de référence :
 *   NUM_COURS  NUMERIC(4)  PK
 *   NOM        VARCHAR(20)
 *   NBHEURES   NUMERIC(2)
 *   ANNEE      NUMERIC(1)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés correspondant aux colonnes ci-dessus.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher le cours de façon lisible.
 * =====================================================================
 */
public class Cours {

    // Attributs (un par colonne de la table COURS)
    private int numCours;
    private String nom;
    private int nbHeures;
    private int annee;

    // Constructeur par défaut (vide)
    public Cours() {
    }

    // Constructeur avec tous les paramètres
    public Cours(int numCours, String nom, int nbHeures, int annee) {
        this.numCours = numCours;
        this.nom = nom;
        this.nbHeures = nbHeures;
        this.annee = annee;
    }

    // Getters et setters

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // toString() : pour afficher le cours de façon lisible
    @Override
    public String toString() {
        return "Cours [numCours=" + numCours
                + ", nom=" + nom
                + ", nbHeures=" + nbHeures
                + ", annee=" + annee + "]";
    }
}
