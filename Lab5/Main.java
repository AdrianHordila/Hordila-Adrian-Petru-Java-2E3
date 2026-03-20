package com.bibliography.main;

import com.bibliography.exception.InvalidCatalogException;
import com.bibliography.model.Resource;
import com.bibliography.repository.Catalog;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Resource r1 = new Resource("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps");
        r1.addTag("author", "Donald E. Knuth");

        Resource r2 = new Resource("java25", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se25/jls25.pdf");

        catalog.add(r1);
        catalog.add(r2);

        // AFISARE IN CONSOLA (Ca sa vezi ca functioneaza)
        System.out.println("Catalogul contine " + catalog.getResources().size() + " resurse:");
        for (Resource r : catalog.getResources()) {
            System.out.println(" - " + r.getTitle() + " [" + r.getId() + "]");
        }

        try {
            System.out.println("\nIncercam sa deschidem resursa: " + r2.getTitle());
            catalog.openResource(r2);
            System.out.println("Resursa a fost deschisa cu succes.");
        } catch (InvalidCatalogException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}