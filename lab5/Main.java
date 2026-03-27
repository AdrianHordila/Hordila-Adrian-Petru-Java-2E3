package org.example;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("Colectia Mea Media");

        // (comanda de add)
        Resource r1 = new Resource("r1", "Curs Programare Java", "https://profs.info.uaic.ro/~acf/", 2024, "C. Frasinaru", "web");
        Resource r2 = new Resource("r2", "Robin Hood", "C:/laborator/Robin_Hood.pdf", 2023, "Autor Anonim", "pdf");
        Resource r3 = new Resource("r3", "Diagrama proiect", "C:/laborator/Diagrama_use_case.png", 2024, "Student", "image");

        catalog.add(r1);
        catalog.add(r2);
        catalog.add(r3);

        try {

            CatalogManager.save(catalog, "catalog.json");
            Catalog loaded = CatalogManager.load("catalog.json");
            CatalogManager.view(r1);
            CatalogManager.reportHtml(loaded);



        } catch (Exception e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}