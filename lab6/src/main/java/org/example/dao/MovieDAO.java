package org.example.dao;

import org.example.Database;
import org.example.model.Movie;
import java.sql.*;

public class MovieDAO {
    public void create(Movie movie) throws SQLException {
        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO movies (id, title, release_date, duration, score, genre_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, movie.getId());
            pstmt.setString(2, movie.getTitle());
            pstmt.setDate(3, Date.valueOf(movie.getReleaseDate()));
            pstmt.setInt(4, movie.getDuration());
            pstmt.setDouble(5, movie.getScore());
            pstmt.setInt(6, movie.getGenreId());
            pstmt.executeUpdate();
        }
    }
}