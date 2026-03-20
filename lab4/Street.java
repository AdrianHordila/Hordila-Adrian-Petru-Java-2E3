package org.example;

public class Street implements Comparable<Street> {
    private final String label;
    private final int distance;
    private final Intersection startNode;
    private final Intersection endNode;

    public Street(String label, int distance, Intersection startNode, Intersection endNode) {
        this.label = label;
        this.distance = distance;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public String getLabel() { return label; }
    public int getDistance() { return distance; }
    public Intersection getStartNode() { return startNode; }
    public Intersection getEndNode() { return endNode; }

    @Override
    public int compareTo(Street other) {
        return Integer.compare(this.distance, other.distance);
    }

    @Override
    public String toString() {
        return label + " (" + distance + "m)";
    }
}