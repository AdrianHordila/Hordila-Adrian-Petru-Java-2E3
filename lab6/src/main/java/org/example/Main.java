package org.example;

import org.example.dao.*;
import org.example.model.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            GenreDAO genreDAO = new GenreDAO();
            MovieDAO movieDAO = new MovieDAO();

            int genreId = (int) (Math.random() * 10000);
            int movieId = (int) (Math.random() * 10000);

            genreDAO.create(new Genre(genreId, "Sci-Fi"));

            Movie m = new Movie(movieId, "Interstellar", "2014-11-07", 169, 8.7, genreId);
            movieDAO.create(m);

            System.out.println("Date inserate cu succes!");

            ReportService report = new ReportService();
            report.generateHTML();
            System.out.println("Raportul HTML a fost generat.");

        } catch (SQLException e) {
            if (e.getErrorCode() == 1) {
                System.out.println("Nota: Datele cu acest ID exista deja in DB, trecem direct la raport.");
                new ReportService().generateHTML();
            } else {
                e.printStackTrace();
            }
        } finally {
            Database.close();
        }
    }
}