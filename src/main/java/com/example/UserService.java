package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";

    // Password should come from environment variables or secrets manager
    private final String password;

    public UserService(String password) {
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, password);
    }

    public void findUser(String username) throws SQLException {

        // Explicitly select only the needed columns
        String query = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");

                    // Log user data instead of printing to console
                    LOGGER.info(() -> "User: " + id + ", " + name + ", " + email);
                }
            }
        }
    }

    public void deleteUser(String username) throws SQLException {

        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeUpdate();
            LOGGER.info(() -> "Deleted user with name: " + username);
        }
    }
}
