package inventario;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private String database;
    private String host;
    private String port;
    private String scheme;
    private String user;
    private String pass;

    private Connection connection;

    public void DbConnection() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }
            properties.load(input);
            database = properties.getProperty("database");
            host = properties.getProperty("host");
            port = properties.getProperty("port");
            scheme = properties.getProperty("scheme");
            user = properties.getProperty("user");
            pass = properties.getProperty("pass");
        } catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private String getStringConnection() {
        StringBuilder str = new StringBuilder();
        str.append(database);
        str.append(host);
        str.append(":");
        str.append(port);
        str.append("/");
        str.append(scheme);
        return str.toString();
    }

    public void connect() {
        try {
            String stringConnection = getStringConnection();
            this.connection = DriverManager.getConnection(stringConnection, user, pass);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void disconnect() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
