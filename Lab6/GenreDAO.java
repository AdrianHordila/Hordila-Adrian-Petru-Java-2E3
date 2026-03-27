package org.example;

import java.sql.*;

public class GenreDAO {
    public void create(String name) throws SQLException {
        String sql = "INSERT INTO genres (id, name) VALUES ((SELECT nvl(max(id), 0) + 1 FROM genres), ?)";
        try (PreparedStatement ps = DB.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        String sql = "SELECT id FROM genres WHERE name = ?";
        try (PreparedStatement ps = DB.getInstance().getConnection().prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt("id") : null;
            }
        }
    }

    public String findById(int id) throws SQLException {
        String sql = "SELECT name FROM genres WHERE id = ?";
        try (PreparedStatement ps = DB.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getString("name") : null;
            }
        }
    }
}