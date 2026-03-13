package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Intersection> allNodes = IntStream.range(0, 10)
                .mapToObj(i -> new Intersection("Inter-0" + i))
                .collect(Collectors.toList());


        Set<Intersection> uniqueSet = new HashSet<>(allNodes);
        uniqueSet.add(new Intersection("Inter-00")); // Aceasta este duplicat si nu se va adauga

        System.out.println("Numar total de elemente in HashSet: " + uniqueSet.size());

      
        LinkedList<Street> cityStreets = new LinkedList<>();
        cityStreets.add(new Street("Street 1", 300, allNodes.get(0), allNodes.get(1)));
        cityStreets.add(new Street("Street 2", 150, allNodes.get(1), allNodes.get(2)));
        cityStreets.add(new Street("Street 3", 500, allNodes.get(2), allNodes.get(3)));
        cityStreets.add(new Street("Street 4", 100, allNodes.get(0), allNodes.get(3)));


        cityStreets.sort((s1, s2) -> Integer.compare(s1.getSize(), s2.getSize()));

        System.out.println("\nStrazile sortate crescator dupa lungime:");
        cityStreets.forEach(s -> System.out.println("- " + s));
    }
}