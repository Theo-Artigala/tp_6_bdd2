package tp.ecole.service;

import tp.ecole.dao.ResultatDAO;
import tp.ecole.dao.ResultatDAOImpl;
import tp.ecole.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Couche service métier pour la gestion de la base Ecole.
 * Contient la logique applicative et la gestion des transactions.
 *
 * =====================================================================
 * TODO (Question 6) :
 *   Implémentez la méthode inscrireEtAttribuerNote en respectant
 *   le cycle transactionnel suivant :
 *
 *   1. Obtenir une Connection via ConnectionManager.getConnection()
 *   2. Désactiver l'autocommit : conn.setAutoCommit(false)
 *   3. Appeler ResultatDAO.enregistrerInscription(...)
 *   4. Appeler ResultatDAO.modifierNote(...)
 *   5. Si tout va bien : conn.commit()
 *   6. En cas d'exception : conn.rollback() puis relancer l'exception
 *   7. Toujours fermer la Connection (try-with-resources ou finally)
 *
 * Question 7 : Testez avec une note invalide (ex. 25) après avoir créé
 *   un trigger de contrôle dans votre base.
 *   Observez si l'inscription EST ou n'est PAS conservée en base.
 *   Expliquez le lien entre setAutoCommit/commit/rollback côté Java
 *   et START TRANSACTION/COMMIT/ROLLBACK côté SGBD.
 * =====================================================================
 */
public class EcoleService {

    private final ResultatDAO resultatDAO = new ResultatDAOImpl();

    /**
     * Inscrit un élève à un cours et lui attribue une note, de manière
     * transactionnelle : soit les deux opérations réussissent ensemble,
     * soit aucune n'est persistée.
     *
     * @param numEleve l'identifiant de l'élève
     * @param numCours l'identifiant du cours
     * @param points   la note à attribuer (0-20)
     * @throws SQLException si une erreur JDBC survient ou si la transaction
     *                      est annulée (note invalide, contrainte violée, etc.)
     */
    public void inscrireEtAttribuerNote(int numEleve, int numCours, double points) throws SQLException {
        // 1. Obtenir une connexion
        Connection conn = ConnectionManager.getConnection();
        try {
            // 2. Désactiver l'autocommit
            conn.setAutoCommit(false);

            // 3. et 4. Les deux opérations avec la même connexion
            resultatDAO.enregistrerInscription(conn, numEleve, numCours);
            resultatDAO.modifierNote(conn, numEleve, numCours, points);

            // 5. Tout s'est bien passé : on valide
            conn.commit();
        } catch (SQLException e) {
            // 6. Erreur : on annule tout puis on relance l'exception
            conn.rollback();
            throw e;
        } finally {
            // 7. Toujours fermer la connexion
            conn.close();
        }
    }

    // ---------------------------------------------------------------
    // TODO (Question 8 – optionnelle) :
    //   Ajoutez une méthode appelant une procédure stockée via
    //   CallableStatement, par exemple :
    //
    //   public void passageClasse(int numEleve) throws SQLException { ... }
    // ---------------------------------------------------------------
}
