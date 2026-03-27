package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            GenreDAO genres = new GenreDAO();

            genres.create("Action");
            genres.create("Drama");

            System.out.println("ID Drama: " + genres.findByName("Drama"));
            System.out.println("Nume ID 1: " + genres.findById(1));

            DB.getInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}