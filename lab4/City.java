package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class City {
    private final List<Street> roadNetwork = new LinkedList<>();
    private final Set<Intersection> nodeRegistry = new HashSet<>();

    public void registerStreet(Street street) {
        roadNetwork.add(street);
        nodeRegistry.add(street.getStartNode());
        nodeRegistry.add(street.getEndNode());
    }

    public List<Street> getRoadNetwork() { return roadNetwork; }
    public Set<Intersection> getNodeRegistry() { return nodeRegistry; }

    public List<Street> filterBusyRoads(int minSize) {
        Map<Intersection, Long> degreeMap = roadNetwork.stream()
                .flatMap(s -> Stream.of(s.getStartNode(), s.getEndNode()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return roadNetwork.stream()
                .filter(s -> s.getDistance() > minSize)
                .filter(s -> degreeMap.getOrDefault(s.getStartNode(), 0L) >= 3
                        || degreeMap.getOrDefault(s.getEndNode(), 0L) >= 3)
                .collect(Collectors.toList());
    }
}