package com.bibliography.repository;

import com.bibliography.exception.InvalidCatalogException;
import com.bibliography.model.Resource;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Resource> resources = new ArrayList<>();

    public void add(Resource resource) {
        resources.add(resource);
    }

    /**
     * Aici folosim clasa Desktop pentru a deschide resursa.
     */
    public void openResource(Resource resource) throws InvalidCatalogException {
        // Desktop class face parte din java.awt
        Desktop desktop = Desktop.getDesktop();
        
        try {
            if (resource.getLocation().startsWith("http")) {
                // Dacă e link, deschide browser-ul
                desktop.browse(new URI(resource.getLocation()));
            } else {
                // Dacă e cale pe disk (ex: d:/books/...), deschide fișierul local
                File file = new File(resource.getLocation());
                if (!file.exists()) {
                    throw new InvalidCatalogException("Fisierul nu exista la: " + resource.getLocation());
                }
                desktop.open(file);
            }
        } catch (IOException | URISyntaxException e) {
            // Împachetăm eroarea în excepția noastră custom
            throw new InvalidCatalogException(e);
        }
    }

    public List<Resource> getResources() {
        return resources;
    }
}