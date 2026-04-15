package it.athon.AriaAPITools.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public void insertUser(String nome, String email) {

        String query = "INSERT INTO utenti (nome, email) VALUES (?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, nome);
                pstmt.setString(2, email);

                pstmt.executeUpdate();
                System.out.println("Utente inserito correttamente");
        } catch (SQLException e) {
            System.err.println("Errore durante l'inserimento: " + e.getMessage());
        }   
    }

    public void getAllUsers() {
    
    String query = "SELECT id, nome, email FROM utenti";

    try (Connection conn = DatabaseConfig.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            System.out.println(id + " | " + nome + " | " + email);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public void logHL7Message(String exchangeId, boolean isError, String errorType, String errorMsg) {
        String sql = "INSERT INTO apachecamel (exchange_Id, is_error, error_type, error_message) VALUES (?,?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, exchangeId);
                pstmt.setBoolean(2, isError);
                pstmt.setString(3, errorType);
                pstmt.setString(4, errorMsg);

                pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
