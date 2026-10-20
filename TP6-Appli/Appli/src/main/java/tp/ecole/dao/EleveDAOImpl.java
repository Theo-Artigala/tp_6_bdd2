package tp.ecole.dao;

import tp.ecole.model.Eleve;
import tp.ecole.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation JDBC de l'interface EleveDAO.
 *
 * =====================================================================
 * TODO (Question 4) :
 *   Implémentez chaque méthode en respectant les règles suivantes :
 *
 *   1. Utilisez ConnectionManager.getConnection() pour obtenir la connexion.
 *   2. Utilisez OBLIGATOIREMENT des PreparedStatement.
 *   3. Utilisez try-with-resources pour fermer les ressources JDBC.
 *   4. Mappez chaque ligne du ResultSet vers un objet Eleve.
 *   5. Gérez les SQLException : choisissez de les propager (throws)
 *      ou de les encapsuler dans une DaoException, et justifiez
 *      votre choix dans le compte-rendu.
 *
 
 * =====================================================================
 */
public class EleveDAOImpl implements EleveDAO {

    @Override
    public List<Eleve> findAll() throws SQLException {
        // TODO : interroger la table ELEVES et retourner tous les élèves
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public Eleve findById(int numEleve) throws SQLException {
        // TODO : SELECT * FROM ELEVES WHERE NUM_ELEVE = ?
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public List<Eleve> findByNom(String nom) throws SQLException {
        // TODO : SELECT * FROM ELEVES WHERE NOM LIKE ?
        //        (penser à ajouter '%' pour une recherche partielle)
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public void save(Eleve eleve) throws SQLException {
        // TODO : INSERT INTO ELEVES (NUM_ELEVE, NOM, PRENOM, ...) VALUES (?, ?, ?, ...)
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public void update(Eleve eleve) throws SQLException {
        // TODO : UPDATE ELEVES SET NOM=?, PRENOM=?, ... WHERE NUM_ELEVE=?
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }

    @Override
    public void delete(int numEleve) throws SQLException {
        // TODO : DELETE FROM ELEVES WHERE NUM_ELEVE=?
        //        Attention : vérifiez qu'il n'y a pas de contraintes de clé étrangère
        //        (l'élève peut avoir des RESULTATS ou ACTIVITES_PRATIQUEES)
        throw new UnsupportedOperationException("À implémenter — Question 4");
    }
}
