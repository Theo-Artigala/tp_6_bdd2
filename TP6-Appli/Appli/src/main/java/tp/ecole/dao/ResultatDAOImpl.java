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
        List<Resultat> resultats = new ArrayList<>();
        String sql = "SELECT * FROM RESULTATS WHERE NUM_ELEVE = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, numEleve);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Resultat resultat = new Resultat();
                    resultat.setNumEleve(rs.getInt("NUM_ELEVE"));
                    resultat.setNumCours(rs.getInt("NUM_COURS"));
                    resultat.setPoints(rs.getDouble("POINTS"));
                    resultats.add(resultat);
                }
            }
        }
        return resultats;
    }

    @Override
    public void enregistrerInscription(int numEleve, int numCours) throws SQLException {
        String sql = "INSERT INTO RESULTATS (NUM_ELEVE, NUM_COURS) VALUES (?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, numEleve);
            ps.setInt(2, numCours);
            ps.executeUpdate();
        }
    }

    @Override
    public void modifierNote(int numEleve, int numCours, double points) throws SQLException {
        // Question 6 (service): Une fois le trigger de contrôle de note créé, une note invalide
        // provoquera une SQLException ici -> le rollback sera déclenché dans EcoleService
        String sql = "UPDATE RESULTATS SET POINTS = ? WHERE NUM_ELEVE = ? AND NUM_COURS = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, points);
            ps.setInt(2, numEleve);
            ps.setInt(3, numCours);
            ps.executeUpdate();
        }
    }

    @Override
    public void enregistrerInscription(Connection conn, int numEleve, int numCours) throws SQLException {
        // On utilise la connexion du service : on ne la ferme pas ici
        String sql = "INSERT INTO RESULTATS (NUM_ELEVE, NUM_COURS) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numEleve);
            ps.setInt(2, numCours);
            ps.executeUpdate();
        }
    }

    @Override
    public void modifierNote(Connection conn, int numEleve, int numCours, double points) throws SQLException {
        // On utilise la connexion du service : on ne la ferme pas ici
        String sql = "UPDATE RESULTATS SET POINTS = ? WHERE NUM_ELEVE = ? AND NUM_COURS = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, points);
            ps.setInt(2, numEleve);
            ps.setInt(3, numCours);
            ps.executeUpdate();
        }
    }
}
