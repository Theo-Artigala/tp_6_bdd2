package tp.ecole.ui;

import tp.ecole.model.Cours;
import tp.ecole.model.Eleve;
import tp.ecole.model.Resultat;

import java.time.LocalDate;

/**
 * Petit main temporaire pour tester les POJO (Question 2).
 * On crée un objet de chaque classe et on affiche son toString().
 */
public class TestModel {

    public static void main(String[] args) {
        // Un élève créé avec le constructeur complet
        Eleve e1 = new Eleve(1, "Brisefer", "Benoit", LocalDate.of(2004, 10, 12), 35, 1, "M");
        System.out.println(e1);

        // Un élève créé avec le constructeur vide + les setters
        Eleve e2 = new Eleve();
        e2.setNumEleve(999);
        e2.setNom("TestNom");
        e2.setPrenom("TestPrenom");
        e2.setDateNaissance(LocalDate.of(2005, 1, 1));
        e2.setPoids(60);
        e2.setAnnee(1);
        e2.setGenre("F");
        System.out.println(e2);

        // Un cours
        Cours c = new Cours(3, "Math", 30, 1);
        System.out.println(c);

        // Un résultat avec une note
        Resultat r1 = new Resultat(1, 3, 14.0);
        System.out.println(r1);

        // Un résultat sans note (inscription seulement)
        Resultat r2 = new Resultat(2, 3, null);
        System.out.println(r2);
    }
}
