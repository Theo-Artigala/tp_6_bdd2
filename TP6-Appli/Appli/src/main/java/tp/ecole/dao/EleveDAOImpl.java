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
        List<Eleve> eleves = new ArrayList<>();
        String sql = "SELECT * FROM ELEVES";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Eleve eleve = new Eleve();
                eleve.setNumEleve(rs.getInt("NUM_ELEVE"));
                eleve.setNom(rs.getString("NOM"));
                eleve.setPrenom(rs.getString("PRENOM"));
                eleve.setDateNaissance(rs.getDate("DATE_NAISSANCE").toLocalDate());
                eleve.setPoids(rs.getInt("POIDS"));
                eleve.setAnnee(rs.getInt("ANNEE"));
                eleve.setGenre(rs.getString("GENRE"));
                eleves.add(eleve);
            }
        }
        return eleves;
    }

    @Override
    public Eleve findById(int numEleve) throws SQLException {
        Eleve eleve = null;
        String sql = "SELECT * FROM ELEVES WHERE NUM_ELEVE = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, numEleve);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    eleve = new Eleve();
                    eleve.setNumEleve(rs.getInt("NUM_ELEVE"));
                    eleve.setNom(rs.getString("NOM"));
                    eleve.setPrenom(rs.getString("PRENOM"));
                    eleve.setDateNaissance(rs.getDate("DATE_NAISSANCE").toLocalDate());
                    eleve.setPoids(rs.getInt("POIDS"));
                    eleve.setAnnee(rs.getInt("ANNEE"));
                    eleve.setGenre(rs.getString("GENRE"));
                }
            }
        }
        return eleve;
    }

    @Override
    public List<Eleve> findByNom(String nom) throws SQLException {
        List<Eleve> eleves = new ArrayList<>();
        String sql = "SELECT * FROM ELEVES WHERE NOM LIKE ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nom + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Eleve eleve = new Eleve();
                    eleve.setNumEleve(rs.getInt("NUM_ELEVE"));
                    eleve.setNom(rs.getString("NOM"));
                    eleve.setPrenom(rs.getString("PRENOM"));
                    eleve.setDateNaissance(rs.getDate("DATE_NAISSANCE").toLocalDate());
                    eleve.setPoids(rs.getInt("POIDS"));
                    eleve.setAnnee(rs.getInt("ANNEE"));
                    eleve.setGenre(rs.getString("GENRE"));
                    eleves.add(eleve);
                }
            }
        }
        return eleves;
    }

    @Override
    public void save(Eleve eleve) throws SQLException {
        String sql = "INSERT INTO ELEVES (NUM_ELEVE, NOM, PRENOM, DATE_NAISSANCE, POIDS, ANNEE, GENRE) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, eleve.getNumEleve());
            ps.setString(2, eleve.getNom());
            ps.setString(3, eleve.getPrenom());
            ps.setDate(4, Date.valueOf(eleve.getDateNaissance()));
            ps.setInt(5, eleve.getPoids());
            ps.setInt(6, eleve.getAnnee());
            ps.setString(7, eleve.getGenre());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Eleve eleve) throws SQLException {
        String sql = "UPDATE ELEVES SET NOM = ?, PRENOM = ?, DATE_NAISSANCE = ?, POIDS = ?, ANNEE = ?, GENRE = ? "
                + "WHERE NUM_ELEVE = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, eleve.getNom());
            ps.setString(2, eleve.getPrenom());
            ps.setDate(3, Date.valueOf(eleve.getDateNaissance()));
            ps.setInt(4, eleve.getPoids());
            ps.setInt(5, eleve.getAnnee());
            ps.setString(6, eleve.getGenre());
            ps.setInt(7, eleve.getNumEleve());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int numEleve) throws SQLException {
        String sql = "DELETE FROM ELEVES WHERE NUM_ELEVE = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, numEleve);
            ps.executeUpdate();
        }
    }
}
