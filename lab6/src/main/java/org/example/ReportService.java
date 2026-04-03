package org.example;

import java.io.PrintWriter;
import java.sql.*;

public class ReportService {
    public void generateHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><h1>Movie Report</h1><table border='1'><tr><th>Title</th><th>Genre</th><th>Score</th></tr>");

        try (Connection con = Database.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT title, genre_name, score FROM movie_report_view")) {

            while (rs.next()) {
                sb.append("<tr><td>").append(rs.getString("title")).append("</td>")
                        .append("<td>").append(rs.getString("genre_name")).append("</td>")
                        .append("<td>").append(rs.getDouble("score")).append("</td></tr>");
            }
            sb.append("</table></body></html>");

            try (PrintWriter out = new PrintWriter("report.html")) {
                out.println(sb.toString());
            }
            System.out.println("Report generated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}