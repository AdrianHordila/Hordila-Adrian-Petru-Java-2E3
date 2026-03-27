package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Resource> resources = new ArrayList<>();

    public Catalog() {}
    public Catalog(String name) { this.name = name; }

    public void add(Resource res) { resources.add(res); }

    public Resource findById(String id) {
        return resources.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Resource> getResources() { return resources; }
    public void setResources(List<Resource> resources) { this.resources = resources; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
