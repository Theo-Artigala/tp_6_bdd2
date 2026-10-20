package tp.ecole.dao;

import tp.ecole.model.Resultat;
import tp.ecole.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation JDBC de l'interface ResultatDAO.
 *
 * =====================================================================
 * TODO (Question 4) :
 *   Implémentez chaque méthode ci-dessous.
 *
 * Note importante sur les transactions (Question 6) :
 *   Les méthodes enregistrerInscription et modifierNote seront utilisées
 *   dans EcoleService.inscrireEtAttribuerNote(), qui gère une transaction.
 *   Pour que la transaction fonctionne correctement, ces méthodes doivent
 *   utiliser la MÊME connexion que celle contrôlée par le service.
 *
 *   => Deux approches possibles :
 *      a) Ajouter un paramètre Connection conn à ces méthodes
 *         (et ne pas appeler getConnection() ici).
 *      b) Injecter la connexion via le constructeur de ResultatDAOImpl.
 *
 *   Discutez de votre choix dans le compte-rendu.
 * =====================================================================
 */
public class ResultatDAOImpl implements ResultatDAO {

    @Override
    public List<Resultat> findByEleve(int numEleve) throws SQLException {
        // TODO : Retourner une liste de résultats pour un élève donné
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public void enregistrerInscription(int numEleve, int numCours) throws SQLException {
        // TODO : Ajouter une nouvelle ligne de note pour un élève, mais sans spécifier les points
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public void modifierNote(int numEleve, int numCours, double points) throws SQLException {
        // TODO : Affecter une note à un élève pour un cours donné.
        // Question 6 (service): Une fois le trigger de contrôle de note créé, une note invalide
        // provoquera une SQLException ici -> le rollback sera déclenché dans EcoleService
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }
}
