package org.example;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker dataGen = new Faker();
        City timisoara = new City();
        Random randomizer = new Random();

        // 1. Compulsory: Create intersections
        List<Intersection> points = IntStream.range(0, 10)
                .mapToObj(i -> new Intersection(dataGen.address().streetAddress()))
                .collect(Collectors.toList());

        // 2. Compulsory: Create streets and sort
        List<Street> rawStreets = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            Intersection p1 = points.get(randomizer.nextInt(points.size()));
            Intersection p2 = points.get(randomizer.nextInt(points.size()));
            if (!p1.equals(p2)) {
                rawStreets.add(new Street(dataGen.color().name() + " St",
                        randomizer.nextInt(500) + 20, p1, p2));
            }
        }

        rawStreets.sort(Street::compareTo);
        rawStreets.forEach(timisoara::registerStreet);

        // 3. Homework: JGraphT MST
        runOptimization(timisoara);

        // 4. Homework: Query
        System.out.println("\n Strazi filtrate (lungime > 200 & grad >= 3) ");
        timisoara.filterBusyRoads(200).forEach(System.out::println);
    }

    private static void runOptimization(City city) {
        Graph<Intersection, DefaultWeightedEdge> cityGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        city.getNodeRegistry().forEach(cityGraph::addVertex);

        for (Street s : city.getRoadNetwork()) {
            DefaultWeightedEdge edge = cityGraph.addEdge(s.getStartNode(), s.getEndNode());
            if (edge != null) {
                cityGraph.setEdgeWeight(edge, s.getDistance());
            }
        }

        var result = new KruskalMinimumSpanningTree<>(cityGraph).getSpanningTree();
       
        System.out.println("Cost total: " + result.getWeight());
        result.getEdges().forEach(e -> System.out.println(cityGraph.getEdgeSource(e) + " -- " + cityGraph.getEdgeTarget(e)));
    }
}