package org.example.dao;

import org.example.Database;
import org.example.model.Actor;
import java.sql.*;

public class ActorDAO {
    public void create(Actor actor) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO actors (id, name) VALUES (?, ?)")) {
            pstmt.setInt(1, actor.getId());
            pstmt.setString(2, actor.getName());
            pstmt.executeUpdate();
        }
    }
}