package tp.ecole.model;

import java.time.LocalDate;

/**
 * POJO représentant un élève de la base ELEVES.
 *
 * Schéma SQL de référence :
 *   NUM_ELEVE  NUMERIC(6)  PK
 *   NOM        VARCHAR(25)
 *   PRENOM     VARCHAR(25)
 *   DATE_NAISSANCE DATE
 *   POIDS      NUMERIC(3)
 *   ANNEE      NUMERIC(1)
 *   GENRE      CHAR(1)
 *
 * =====================================================================
 * TODO (Question 2) :
 *   1. Ajoutez les attributs privés correspondant aux colonnes ci-dessus.
 *   2. Créez un constructeur sans argument et un constructeur complet.
 *   3. Générez (ou écrivez) les getters et setters pour chaque attribut.
 *   4. Redéfinissez toString() pour afficher l'élève de façon lisible.
 *
 * Question : En quoi ce modèle objet diffère-t-il du modèle relationnel ?
 *
 * Réponse :
 *   - Dans le modèle relationnel, les données sont rangées dans des tables
 *     (lignes et colonnes). Un élève est une ligne de la table ELEVES.
 *     En objet, un élève est un objet Java qui a des attributs ET des
 *     méthodes (getters, setters, toString...).
 *   - En relationnel, les liens entre tables se font avec des clés
 *     étrangères (ex : RESULTATS.NUM_ELEVE -> ELEVES.NUM_ELEVE).
 *     En objet, les liens se font avec des références vers d'autres
 *     objets (ex : un Eleve pourrait avoir une List<Resultat>).
 *   - Les types ne sont pas les mêmes : NUMERIC devient int ou double,
 *     VARCHAR devient String, DATE devient LocalDate...
 *   - En relationnel, une valeur peut être NULL. En Java, un type
 *     primitif (int, double) ne peut pas être null, il faut utiliser
 *     Integer / Double si on veut pouvoir avoir null.
 *   - L'objet existe en mémoire (il disparaît quand le programme
 *     s'arrête), alors que la ligne en base est stockée durablement.
 *     C'est pour ça qu'il faut une couche (le DAO) qui fait la
 *     "traduction" entre les deux.
 * =====================================================================
 */
public class Eleve {

    // Attributs (un par colonne de la table ELEVES)
    private int numEleve;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int poids;
    private int annee;
    private String genre;

    // Constructeur par défaut (vide)
    public Eleve() {
    }

    // Constructeur avec tous les paramètres
    public Eleve(int numEleve, String nom, String prenom, LocalDate dateNaissance, int poids, int annee, String genre) {
        this.numEleve = numEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.poids = poids;
        this.annee = annee;
        this.genre = genre;
    }

    // Getters et setters

    public int getNumEleve() {
        return numEleve;
    }

    public void setNumEleve(int numEleve) {
        this.numEleve = numEleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // toString() : pour afficher l'élève de façon lisible
    @Override
    public String toString() {
        return "Eleve [numEleve=" + numEleve
                + ", nom=" + nom
                + ", prenom=" + prenom
                + ", dateNaissance=" + dateNaissance
                + ", poids=" + poids
                + ", annee=" + annee
                + ", genre=" + genre + "]";
    }
}
