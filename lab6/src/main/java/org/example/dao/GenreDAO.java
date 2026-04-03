package org.example.dao;

import org.example.Database;
import org.example.model.Genre;
import java.sql.*;

public class GenreDAO {
    public void create(Genre genre) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO genres (id, name) VALUES (?, ?)")) {
            pstmt.setInt(1, genre.getId());
            pstmt.setString(2, genre.getName());
            pstmt.executeUpdate();
        }
    }

    public String findById(int id) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT name FROM genres WHERE id = ?")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
    }
}