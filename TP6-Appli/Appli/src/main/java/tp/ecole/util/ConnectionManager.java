package tp.ecole.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe utilitaire pour la gestion de la connexion JDBC à la base Ecole.
 *
 * =====================================================================
 * TODO (Question 1.2) :
 *   - Renseignez les constantes DB_URL, DB_USER et DB_PASSWORD
 *     avec les paramètres de connexion à VOTRE instance MySQL.
 *   - La méthode getConnection() doit retourner une connexion active.
 *   - Testez-la via la classe TestConnection dans le package tp.ecole.main.
 * =====================================================================
 */
public class ConnectionManager {

    // ---------------------------------------------------------------
    // Paramètres de connexion lus depuis src/main/resources/db.properties
    // (fichier ignoré par git, voir db.properties.example)
    // ---------------------------------------------------------------
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PASSWORD;

    static {
        Properties props = new Properties();
        try (InputStream in = ConnectionManager.class.getResourceAsStream("/db.properties")) {
            if (in == null) {
                throw new IllegalStateException("db.properties introuvable — copiez db.properties.example en db.properties");
            }
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
        DB_URL      = props.getProperty("db.url");
        DB_USER     = props.getProperty("db.user");
        DB_PASSWORD = props.getProperty("db.password");
    }
    // ---------------------------------------------------------------

    /** Constructeur privé : classe utilitaire, pas d'instanciation. */
    private ConnectionManager() {}

    /**
     * Retourne une nouvelle connexion JDBC vers la base Ecole.
     *
     * @return une {@link Connection} ouverte
     * @throws SQLException si la connexion échoue
     *
     * TODO : complétez cette méthode (elle est déjà fonctionnelle si
     *        les constantes ci-dessus sont correctement renseignées).
     */
    public static Connection getConnection() throws SQLException {
        // TODO : retourner une connexion JDBC en utilisant DriverManager
        throw new UnsupportedOperationException("ConnectionManager.getConnection() non implémenté — voir TODO");
    }
}
